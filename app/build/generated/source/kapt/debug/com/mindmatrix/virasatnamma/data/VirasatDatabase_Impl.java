package com.mindmatrix.virasatnamma.data;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class VirasatDatabase_Impl extends VirasatDatabase {
  private volatile HeritageSiteDao _heritageSiteDao;

  private volatile CheckInDao _checkInDao;

  private volatile UserProgressDao _userProgressDao;

  private volatile FavoriteDao _favoriteDao;

  private volatile UserAchievementDao _userAchievementDao;

  @Override
  @NonNull
  protected RoomOpenDelegate createOpenDelegate() {
    final RoomOpenDelegate _openDelegate = new RoomOpenDelegate(2, "d6a9652f65c42a23da5d3f80613af34e", "48d8812cf177345e7e2bd5dbb9b35420") {
      @Override
      public void createAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `heritage_sites` (`siteId` TEXT NOT NULL, `name` TEXT NOT NULL, `nameKannada` TEXT NOT NULL, `description` TEXT NOT NULL, `descriptionKannada` TEXT NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `audioFilePathEn` TEXT, `audioFilePathKn` TEXT, `imageUris` TEXT NOT NULL, `hiddenFact` TEXT NOT NULL, `hiddenFactKannada` TEXT NOT NULL, `category` TEXT NOT NULL, `era` TEXT NOT NULL, `significance` TEXT NOT NULL, `isUserCreated` INTEGER NOT NULL, PRIMARY KEY(`siteId`))");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `check_ins` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `siteId` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `hasUnlockedHiddenFact` INTEGER NOT NULL)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `user_progress` (`userId` INTEGER NOT NULL, `totalVisits` INTEGER NOT NULL, `sitesVisited` INTEGER NOT NULL, `hiddenFactsUnlocked` INTEGER NOT NULL, `favoriteLanguage` TEXT NOT NULL, `displayName` TEXT NOT NULL, `placeFrom` TEXT NOT NULL, PRIMARY KEY(`userId`))");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `favorites` (`siteId` TEXT NOT NULL, `addedTimestamp` INTEGER NOT NULL, PRIMARY KEY(`siteId`))");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `user_achievements` (`achievementId` TEXT NOT NULL, `unlockedAt` INTEGER NOT NULL, `progress` INTEGER NOT NULL, PRIMARY KEY(`achievementId`))");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'd6a9652f65c42a23da5d3f80613af34e')");
      }

      @Override
      public void dropAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `heritage_sites`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `check_ins`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `user_progress`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `favorites`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `user_achievements`");
      }

      @Override
      public void onCreate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      public void onOpen(@NonNull final SQLiteConnection connection) {
        internalInitInvalidationTracker(connection);
      }

      @Override
      public void onPreMigrate(@NonNull final SQLiteConnection connection) {
        DBUtil.dropFtsSyncTriggers(connection);
      }

      @Override
      public void onPostMigrate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      @NonNull
      public RoomOpenDelegate.ValidationResult onValidateSchema(
          @NonNull final SQLiteConnection connection) {
        final Map<String, TableInfo.Column> _columnsHeritageSites = new HashMap<String, TableInfo.Column>(16);
        _columnsHeritageSites.put("siteId", new TableInfo.Column("siteId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHeritageSites.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHeritageSites.put("nameKannada", new TableInfo.Column("nameKannada", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHeritageSites.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHeritageSites.put("descriptionKannada", new TableInfo.Column("descriptionKannada", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHeritageSites.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHeritageSites.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHeritageSites.put("audioFilePathEn", new TableInfo.Column("audioFilePathEn", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHeritageSites.put("audioFilePathKn", new TableInfo.Column("audioFilePathKn", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHeritageSites.put("imageUris", new TableInfo.Column("imageUris", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHeritageSites.put("hiddenFact", new TableInfo.Column("hiddenFact", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHeritageSites.put("hiddenFactKannada", new TableInfo.Column("hiddenFactKannada", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHeritageSites.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHeritageSites.put("era", new TableInfo.Column("era", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHeritageSites.put("significance", new TableInfo.Column("significance", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHeritageSites.put("isUserCreated", new TableInfo.Column("isUserCreated", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysHeritageSites = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesHeritageSites = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHeritageSites = new TableInfo("heritage_sites", _columnsHeritageSites, _foreignKeysHeritageSites, _indicesHeritageSites);
        final TableInfo _existingHeritageSites = TableInfo.read(connection, "heritage_sites");
        if (!_infoHeritageSites.equals(_existingHeritageSites)) {
          return new RoomOpenDelegate.ValidationResult(false, "heritage_sites(com.mindmatrix.virasatnamma.data.HeritageSite).\n"
                  + " Expected:\n" + _infoHeritageSites + "\n"
                  + " Found:\n" + _existingHeritageSites);
        }
        final Map<String, TableInfo.Column> _columnsCheckIns = new HashMap<String, TableInfo.Column>(4);
        _columnsCheckIns.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCheckIns.put("siteId", new TableInfo.Column("siteId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCheckIns.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCheckIns.put("hasUnlockedHiddenFact", new TableInfo.Column("hasUnlockedHiddenFact", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysCheckIns = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesCheckIns = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCheckIns = new TableInfo("check_ins", _columnsCheckIns, _foreignKeysCheckIns, _indicesCheckIns);
        final TableInfo _existingCheckIns = TableInfo.read(connection, "check_ins");
        if (!_infoCheckIns.equals(_existingCheckIns)) {
          return new RoomOpenDelegate.ValidationResult(false, "check_ins(com.mindmatrix.virasatnamma.data.CheckIn).\n"
                  + " Expected:\n" + _infoCheckIns + "\n"
                  + " Found:\n" + _existingCheckIns);
        }
        final Map<String, TableInfo.Column> _columnsUserProgress = new HashMap<String, TableInfo.Column>(7);
        _columnsUserProgress.put("userId", new TableInfo.Column("userId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProgress.put("totalVisits", new TableInfo.Column("totalVisits", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProgress.put("sitesVisited", new TableInfo.Column("sitesVisited", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProgress.put("hiddenFactsUnlocked", new TableInfo.Column("hiddenFactsUnlocked", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProgress.put("favoriteLanguage", new TableInfo.Column("favoriteLanguage", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProgress.put("displayName", new TableInfo.Column("displayName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserProgress.put("placeFrom", new TableInfo.Column("placeFrom", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysUserProgress = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesUserProgress = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserProgress = new TableInfo("user_progress", _columnsUserProgress, _foreignKeysUserProgress, _indicesUserProgress);
        final TableInfo _existingUserProgress = TableInfo.read(connection, "user_progress");
        if (!_infoUserProgress.equals(_existingUserProgress)) {
          return new RoomOpenDelegate.ValidationResult(false, "user_progress(com.mindmatrix.virasatnamma.data.UserProgress).\n"
                  + " Expected:\n" + _infoUserProgress + "\n"
                  + " Found:\n" + _existingUserProgress);
        }
        final Map<String, TableInfo.Column> _columnsFavorites = new HashMap<String, TableInfo.Column>(2);
        _columnsFavorites.put("siteId", new TableInfo.Column("siteId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavorites.put("addedTimestamp", new TableInfo.Column("addedTimestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysFavorites = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesFavorites = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFavorites = new TableInfo("favorites", _columnsFavorites, _foreignKeysFavorites, _indicesFavorites);
        final TableInfo _existingFavorites = TableInfo.read(connection, "favorites");
        if (!_infoFavorites.equals(_existingFavorites)) {
          return new RoomOpenDelegate.ValidationResult(false, "favorites(com.mindmatrix.virasatnamma.data.Favorite).\n"
                  + " Expected:\n" + _infoFavorites + "\n"
                  + " Found:\n" + _existingFavorites);
        }
        final Map<String, TableInfo.Column> _columnsUserAchievements = new HashMap<String, TableInfo.Column>(3);
        _columnsUserAchievements.put("achievementId", new TableInfo.Column("achievementId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserAchievements.put("unlockedAt", new TableInfo.Column("unlockedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserAchievements.put("progress", new TableInfo.Column("progress", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysUserAchievements = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesUserAchievements = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserAchievements = new TableInfo("user_achievements", _columnsUserAchievements, _foreignKeysUserAchievements, _indicesUserAchievements);
        final TableInfo _existingUserAchievements = TableInfo.read(connection, "user_achievements");
        if (!_infoUserAchievements.equals(_existingUserAchievements)) {
          return new RoomOpenDelegate.ValidationResult(false, "user_achievements(com.mindmatrix.virasatnamma.data.UserAchievement).\n"
                  + " Expected:\n" + _infoUserAchievements + "\n"
                  + " Found:\n" + _existingUserAchievements);
        }
        return new RoomOpenDelegate.ValidationResult(true, null);
      }
    };
    return _openDelegate;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final Map<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final Map<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "heritage_sites", "check_ins", "user_progress", "favorites", "user_achievements");
  }

  @Override
  public void clearAllTables() {
    super.performClear(false, "heritage_sites", "check_ins", "user_progress", "favorites", "user_achievements");
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final Map<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(HeritageSiteDao.class, HeritageSiteDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CheckInDao.class, CheckInDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserProgressDao.class, UserProgressDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(FavoriteDao.class, FavoriteDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserAchievementDao.class, UserAchievementDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final Set<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public HeritageSiteDao heritageSiteDao() {
    if (_heritageSiteDao != null) {
      return _heritageSiteDao;
    } else {
      synchronized(this) {
        if(_heritageSiteDao == null) {
          _heritageSiteDao = new HeritageSiteDao_Impl(this);
        }
        return _heritageSiteDao;
      }
    }
  }

  @Override
  public CheckInDao checkInDao() {
    if (_checkInDao != null) {
      return _checkInDao;
    } else {
      synchronized(this) {
        if(_checkInDao == null) {
          _checkInDao = new CheckInDao_Impl(this);
        }
        return _checkInDao;
      }
    }
  }

  @Override
  public UserProgressDao userProgressDao() {
    if (_userProgressDao != null) {
      return _userProgressDao;
    } else {
      synchronized(this) {
        if(_userProgressDao == null) {
          _userProgressDao = new UserProgressDao_Impl(this);
        }
        return _userProgressDao;
      }
    }
  }

  @Override
  public FavoriteDao favoriteDao() {
    if (_favoriteDao != null) {
      return _favoriteDao;
    } else {
      synchronized(this) {
        if(_favoriteDao == null) {
          _favoriteDao = new FavoriteDao_Impl(this);
        }
        return _favoriteDao;
      }
    }
  }

  @Override
  public UserAchievementDao userAchievementDao() {
    if (_userAchievementDao != null) {
      return _userAchievementDao;
    } else {
      synchronized(this) {
        if(_userAchievementDao == null) {
          _userAchievementDao = new UserAchievementDao_Impl(this);
        }
        return _userAchievementDao;
      }
    }
  }
}
