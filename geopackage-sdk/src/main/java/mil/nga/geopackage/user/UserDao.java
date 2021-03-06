package mil.nga.geopackage.user;

import android.content.ContentValues;

import mil.nga.geopackage.db.GeoPackageConnection;
import mil.nga.geopackage.db.GeoPackageDatabase;

/**
 * Abstract User DAO for reading user tables
 *
 * @param <TColumn>
 * @param <TTable>
 * @param <TRow>
 * @param <TResult>
 * @author osbornb
 */
public abstract class UserDao<TColumn extends UserColumn, TTable extends UserTable<TColumn>, TRow extends UserRow<TColumn, TTable>, TResult extends UserCursor<TColumn, TTable, TRow>>
        extends UserCoreDao<TColumn, TTable, TRow, TResult> {

    /**
     * Database connection
     */
    private final GeoPackageDatabase db;

    /**
     * Constructor
     *
     * @param database
     * @param db
     * @param userDb
     * @param table
     */
    protected UserDao(String database, GeoPackageConnection db,
                      UserConnection<TColumn, TTable, TRow, TResult> userDb,
                      TTable table) {
        super(database, db, userDb, table);
        this.db = db.getDb();
    }

    /**
     * Get the database connection
     *
     * @return database
     * @since 1.3.1
     */
    public GeoPackageDatabase getDatabaseConnection() {
        return db;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int update(TRow row) {
        ContentValues contentValues = row.toContentValues();
        int updated = 0;
        if (contentValues.size() > 0) {
            updated = db.update(getTableName(), contentValues,
                    getPkWhere(row.getId()), getPkWhereArgs(row.getId()));
        }
        return updated;
    }

    /**
     * Update all rows matching the where clause with the provided values
     *
     * @param values
     * @param whereClause
     * @param whereArgs
     * @return
     */
    public int update(ContentValues values, String whereClause,
                      String[] whereArgs) {
        return db.update(getTableName(), values, whereClause, whereArgs);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long insert(TRow row) {
        long id = db.insertOrThrow(getTableName(), null, row.toContentValues());
        row.setId(id);
        return id;
    }

    /**
     * Inserts a new row
     *
     * @param values
     * @return row id, -1 on error
     */
    public long insert(ContentValues values) {
        return db.insert(getTableName(), null, values);
    }

    /**
     * Inserts a new row
     *
     * @param values
     * @return row id
     */
    public long insertOrThrow(ContentValues values) {
        return db.insertOrThrow(getTableName(), null, values);
    }

}
