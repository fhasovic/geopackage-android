package mil.nga.giat.geopackage.data.c2;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import mil.nga.giat.geopackage.data.c3.GeometryColumns;
import mil.nga.giat.geopackage.data.c3.GeometryColumnsDao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.support.ConnectionSource;

/**
 * Contents Data Access Object
 * 
 * @author osbornb
 */
public class ContentsDao extends BaseDaoImpl<Contents, String> {

	/**
	 * Geometry Columns DAO
	 */
	private GeometryColumnsDao geometryColumnsDao;

	/**
	 * Constructor, required by ORMLite
	 * 
	 * @param connectionSource
	 * @param dataClass
	 * @throws SQLException
	 */
	public ContentsDao(ConnectionSource connectionSource,
			Class<Contents> dataClass) throws SQLException {
		super(connectionSource, dataClass);
	}

	/**
	 * Delete the Contents, cascading to TODO
	 * 
	 * @param contents
	 * @return
	 * @throws SQLException
	 */
	public int deleteCascade(Contents contents) throws SQLException {
		int count = 0;

		if (contents != null) {

			// Delete Geometry Columns
			GeometryColumnsDao dao = getGeometryColumnsDao();
			if (dao.isTableExists()) {
				ForeignCollection<GeometryColumns> geometryColumnsCollection = contents
						.getGeometryColumns();
				if (!geometryColumnsCollection.isEmpty()) {
					dao.delete(geometryColumnsCollection);
				}
			}

			count = super.delete(contents);
		}
		return count;
	}

	/**
	 * Delete the collection of Contents, cascading to TODO
	 * 
	 * @param contentsCollection
	 * @return
	 * @throws SQLException
	 */
	public int deleteCascade(Collection<Contents> contentsCollection)
			throws SQLException {
		int count = 0;
		if (contentsCollection != null) {
			for (Contents contents : contentsCollection) {
				count += deleteCascade(contents);
			}
		}
		return count;
	}

	/**
	 * Delete the Contents matching the prepared query, cascading to TODO
	 * 
	 * @param preparedDelete
	 * @return
	 * @throws SQLException
	 */
	public int deleteCascade(PreparedQuery<Contents> preparedDelete)
			throws SQLException {
		int count = 0;
		if (preparedDelete != null) {
			List<Contents> contentsList = super.query(preparedDelete);
			count = deleteCascade(contentsList);
		}
		return count;
	}

	/**
	 * Delete a Contents by id, cascading to TODO
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int deleteByIdCascade(String id) throws SQLException {
		int count = 0;
		if (id != null) {
			Contents contents = super.queryForId(id);
			if (contents != null) {
				count = deleteCascade(contents);
			}
		}
		return count;
	}

	/**
	 * Delete the Contents with the provided ids, cascading to TODO
	 * 
	 * @param idCollection
	 * @return
	 * @throws SQLException
	 */
	public int deleteIdsCascade(Collection<String> idCollection)
			throws SQLException {
		int count = 0;
		if (idCollection != null) {
			for (String id : idCollection) {
				count += deleteByIdCascade(id);
			}
		}
		return count;
	}

	/**
	 * Get or create a Geometry Columns DAO
	 * 
	 * @return
	 * @throws SQLException
	 */
	private GeometryColumnsDao getGeometryColumnsDao() throws SQLException {
		if (geometryColumnsDao == null) {
			geometryColumnsDao = DaoManager.createDao(connectionSource,
					GeometryColumns.class);
		}
		return geometryColumnsDao;
	}

}
