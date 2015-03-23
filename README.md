----------------
Temporary README
----------------
For tracking information


--- Dependencies ---

OrmLite:
http://ormlite.com/
Open Source License
ormlite-android-4.48.jar
ormlite-core-4.48.jar

Proj4J:
http://trac.osgeo.org/proj4j/
Apache License, Version 2.0
src/org/osgeo/proj4j/

aFileChooser:
https://github.com/iPaulPro/aFileChooser
Apache License, Version 2.0
sample/src/com/ipaulpro/afilechooser/utils/FileUtils.java
Used by Sample Application


--- Assets ---

The SDK sql assets must be linked when using the library.
Link (or copy) the assets/sql directory from the SDK to your project assets directory.


--- Sample Application ---

Add the GeoPackageSDKSample project under sample.
Link the assets directory (from sample/assets: ln -s ../../assets/sql sql)


--- Tests ---

To run tests, change AndroidManifest.xml android.library to true.
Add the GeoPackageSDKTests project under tests.
Run the project as Android JUnits