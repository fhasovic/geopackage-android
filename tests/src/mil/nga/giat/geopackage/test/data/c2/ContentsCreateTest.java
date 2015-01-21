package mil.nga.giat.geopackage.test.data.c2;

import java.sql.SQLException;

import mil.nga.giat.geopackage.GeoPackage;
import mil.nga.giat.geopackage.GeoPackageActivity;
import mil.nga.giat.geopackage.test.TestUtils;
import mil.nga.giat.geopackage.util.GeoPackageException;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

/**
 * Test Contents from a created database (C.2. gpkg_contents)
 * 
 * @author osbornb
 */
public class ContentsCreateTest extends
		ActivityInstrumentationTestCase2<GeoPackageActivity> {

	/**
	 * GeoPackage activity
	 */
	private Activity activity = null;

	/**
	 * GeoPackage
	 */
	private GeoPackage geoPackage = null;

	/**
	 * Constructor
	 */
	public ContentsCreateTest() {
		super(GeoPackageActivity.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();

		// Set the activity
		activity = getActivity();

		// Create the database
		geoPackage = TestUtils.setUpCreate(activity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void tearDown() throws Exception {

		// Tear down the create database
		TestUtils.tearDownCreate(activity, geoPackage);

		super.tearDown();
	}

	/**
	 * Test reading
	 * 
	 * @throws GeoPackageException
	 * @throws SQLException
	 */
	public void testRead() throws GeoPackageException, SQLException {

		ContentsUtils.testRead(geoPackage, 2);

	}

	/**
	 * Test updating
	 * 
	 * @throws GeoPackageException
	 * @throws SQLException
	 */
	public void testUpdate() throws GeoPackageException, SQLException {

		ContentsUtils.testUpdate(geoPackage);

	}

	/**
	 * Test creating
	 * 
	 * @throws GeoPackageException
	 * @throws SQLException
	 */
	public void testCreate() throws GeoPackageException, SQLException {

		ContentsUtils.testCreate(geoPackage);

	}

	/**
	 * Test deleting
	 * 
	 * @throws GeoPackageException
	 * @throws SQLException
	 */
	public void testDelete() throws GeoPackageException, SQLException {

		ContentsUtils.testDelete(geoPackage);

	}

	/**
	 * Test cascade deleting
	 * 
	 * @throws GeoPackageException
	 * @throws SQLException
	 */
	public void testDeleteCascade() throws GeoPackageException, SQLException {

		ContentsUtils.testDeleteCascade(geoPackage);

	}

}
