package com.mindmatrix.virasatnamma.data;

import androidx.annotation.NonNull;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import java.lang.Class;
import java.lang.Integer;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class HeritageSiteDao_Impl implements HeritageSiteDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<HeritageSite> __insertAdapterOfHeritageSite;

  private final EntityDeleteOrUpdateAdapter<HeritageSite> __updateAdapterOfHeritageSite;

  public HeritageSiteDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfHeritageSite = new EntityInsertAdapter<HeritageSite>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `heritage_sites` (`siteId`,`name`,`nameKannada`,`description`,`descriptionKannada`,`latitude`,`longitude`,`audioFilePathEn`,`audioFilePathKn`,`imageUris`,`hiddenFact`,`hiddenFactKannada`,`category`,`era`,`significance`,`isUserCreated`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final HeritageSite entity) {
        if (entity.getSiteId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getSiteId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getName());
        }
        if (entity.getNameKannada() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getNameKannada());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getDescription());
        }
        if (entity.getDescriptionKannada() == null) {
          statement.bindNull(5);
        } else {
          statement.bindText(5, entity.getDescriptionKannada());
        }
        statement.bindDouble(6, entity.getLatitude());
        statement.bindDouble(7, entity.getLongitude());
        if (entity.getAudioFilePathEn() == null) {
          statement.bindNull(8);
        } else {
          statement.bindText(8, entity.getAudioFilePathEn());
        }
        if (entity.getAudioFilePathKn() == null) {
          statement.bindNull(9);
        } else {
          statement.bindText(9, entity.getAudioFilePathKn());
        }
        if (entity.getImageUris() == null) {
          statement.bindNull(10);
        } else {
          statement.bindText(10, entity.getImageUris());
        }
        if (entity.getHiddenFact() == null) {
          statement.bindNull(11);
        } else {
          statement.bindText(11, entity.getHiddenFact());
        }
        if (entity.getHiddenFactKannada() == null) {
          statement.bindNull(12);
        } else {
          statement.bindText(12, entity.getHiddenFactKannada());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(13);
        } else {
          statement.bindText(13, entity.getCategory());
        }
        if (entity.getEra() == null) {
          statement.bindNull(14);
        } else {
          statement.bindText(14, entity.getEra());
        }
        if (entity.getSignificance() == null) {
          statement.bindNull(15);
        } else {
          statement.bindText(15, entity.getSignificance());
        }
        final int _tmp = entity.isUserCreated() ? 1 : 0;
        statement.bindLong(16, _tmp);
      }
    };
    this.__updateAdapterOfHeritageSite = new EntityDeleteOrUpdateAdapter<HeritageSite>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `heritage_sites` SET `siteId` = ?,`name` = ?,`nameKannada` = ?,`description` = ?,`descriptionKannada` = ?,`latitude` = ?,`longitude` = ?,`audioFilePathEn` = ?,`audioFilePathKn` = ?,`imageUris` = ?,`hiddenFact` = ?,`hiddenFactKannada` = ?,`category` = ?,`era` = ?,`significance` = ?,`isUserCreated` = ? WHERE `siteId` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final HeritageSite entity) {
        if (entity.getSiteId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getSiteId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getName());
        }
        if (entity.getNameKannada() == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.getNameKannada());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getDescription());
        }
        if (entity.getDescriptionKannada() == null) {
          statement.bindNull(5);
        } else {
          statement.bindText(5, entity.getDescriptionKannada());
        }
        statement.bindDouble(6, entity.getLatitude());
        statement.bindDouble(7, entity.getLongitude());
        if (entity.getAudioFilePathEn() == null) {
          statement.bindNull(8);
        } else {
          statement.bindText(8, entity.getAudioFilePathEn());
        }
        if (entity.getAudioFilePathKn() == null) {
          statement.bindNull(9);
        } else {
          statement.bindText(9, entity.getAudioFilePathKn());
        }
        if (entity.getImageUris() == null) {
          statement.bindNull(10);
        } else {
          statement.bindText(10, entity.getImageUris());
        }
        if (entity.getHiddenFact() == null) {
          statement.bindNull(11);
        } else {
          statement.bindText(11, entity.getHiddenFact());
        }
        if (entity.getHiddenFactKannada() == null) {
          statement.bindNull(12);
        } else {
          statement.bindText(12, entity.getHiddenFactKannada());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(13);
        } else {
          statement.bindText(13, entity.getCategory());
        }
        if (entity.getEra() == null) {
          statement.bindNull(14);
        } else {
          statement.bindText(14, entity.getEra());
        }
        if (entity.getSignificance() == null) {
          statement.bindNull(15);
        } else {
          statement.bindText(15, entity.getSignificance());
        }
        final int _tmp = entity.isUserCreated() ? 1 : 0;
        statement.bindLong(16, _tmp);
        if (entity.getSiteId() == null) {
          statement.bindNull(17);
        } else {
          statement.bindText(17, entity.getSiteId());
        }
      }
    };
  }

  @Override
  public Object insertSite(final HeritageSite site, final Continuation<? super Unit> $completion) {
    if (site == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfHeritageSite.insert(_connection, site);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object insertSites(final List<HeritageSite> sites,
      final Continuation<? super Unit> $completion) {
    if (sites == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfHeritageSite.insert(_connection, sites);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object updateSite(final HeritageSite site, final Continuation<? super Unit> $completion) {
    if (site == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __updateAdapterOfHeritageSite.handle(_connection, site);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Flow<List<HeritageSite>> getAllSites() {
    final String _sql = "SELECT * FROM heritage_sites ORDER BY name";
    return FlowUtil.createFlow(__db, false, new String[] {"heritage_sites"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfSiteId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "siteId");
        final int _columnIndexOfName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "name");
        final int _columnIndexOfNameKannada = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "nameKannada");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfDescriptionKannada = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "descriptionKannada");
        final int _columnIndexOfLatitude = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "latitude");
        final int _columnIndexOfLongitude = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "longitude");
        final int _columnIndexOfAudioFilePathEn = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "audioFilePathEn");
        final int _columnIndexOfAudioFilePathKn = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "audioFilePathKn");
        final int _columnIndexOfImageUris = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "imageUris");
        final int _columnIndexOfHiddenFact = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "hiddenFact");
        final int _columnIndexOfHiddenFactKannada = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "hiddenFactKannada");
        final int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
        final int _columnIndexOfEra = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "era");
        final int _columnIndexOfSignificance = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "significance");
        final int _columnIndexOfIsUserCreated = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isUserCreated");
        final List<HeritageSite> _result = new ArrayList<HeritageSite>();
        while (_stmt.step()) {
          final HeritageSite _item;
          final String _tmpSiteId;
          if (_stmt.isNull(_columnIndexOfSiteId)) {
            _tmpSiteId = null;
          } else {
            _tmpSiteId = _stmt.getText(_columnIndexOfSiteId);
          }
          final String _tmpName;
          if (_stmt.isNull(_columnIndexOfName)) {
            _tmpName = null;
          } else {
            _tmpName = _stmt.getText(_columnIndexOfName);
          }
          final String _tmpNameKannada;
          if (_stmt.isNull(_columnIndexOfNameKannada)) {
            _tmpNameKannada = null;
          } else {
            _tmpNameKannada = _stmt.getText(_columnIndexOfNameKannada);
          }
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final String _tmpDescriptionKannada;
          if (_stmt.isNull(_columnIndexOfDescriptionKannada)) {
            _tmpDescriptionKannada = null;
          } else {
            _tmpDescriptionKannada = _stmt.getText(_columnIndexOfDescriptionKannada);
          }
          final double _tmpLatitude;
          _tmpLatitude = _stmt.getDouble(_columnIndexOfLatitude);
          final double _tmpLongitude;
          _tmpLongitude = _stmt.getDouble(_columnIndexOfLongitude);
          final String _tmpAudioFilePathEn;
          if (_stmt.isNull(_columnIndexOfAudioFilePathEn)) {
            _tmpAudioFilePathEn = null;
          } else {
            _tmpAudioFilePathEn = _stmt.getText(_columnIndexOfAudioFilePathEn);
          }
          final String _tmpAudioFilePathKn;
          if (_stmt.isNull(_columnIndexOfAudioFilePathKn)) {
            _tmpAudioFilePathKn = null;
          } else {
            _tmpAudioFilePathKn = _stmt.getText(_columnIndexOfAudioFilePathKn);
          }
          final String _tmpImageUris;
          if (_stmt.isNull(_columnIndexOfImageUris)) {
            _tmpImageUris = null;
          } else {
            _tmpImageUris = _stmt.getText(_columnIndexOfImageUris);
          }
          final String _tmpHiddenFact;
          if (_stmt.isNull(_columnIndexOfHiddenFact)) {
            _tmpHiddenFact = null;
          } else {
            _tmpHiddenFact = _stmt.getText(_columnIndexOfHiddenFact);
          }
          final String _tmpHiddenFactKannada;
          if (_stmt.isNull(_columnIndexOfHiddenFactKannada)) {
            _tmpHiddenFactKannada = null;
          } else {
            _tmpHiddenFactKannada = _stmt.getText(_columnIndexOfHiddenFactKannada);
          }
          final String _tmpCategory;
          if (_stmt.isNull(_columnIndexOfCategory)) {
            _tmpCategory = null;
          } else {
            _tmpCategory = _stmt.getText(_columnIndexOfCategory);
          }
          final String _tmpEra;
          if (_stmt.isNull(_columnIndexOfEra)) {
            _tmpEra = null;
          } else {
            _tmpEra = _stmt.getText(_columnIndexOfEra);
          }
          final String _tmpSignificance;
          if (_stmt.isNull(_columnIndexOfSignificance)) {
            _tmpSignificance = null;
          } else {
            _tmpSignificance = _stmt.getText(_columnIndexOfSignificance);
          }
          final boolean _tmpIsUserCreated;
          final int _tmp;
          _tmp = (int) (_stmt.getLong(_columnIndexOfIsUserCreated));
          _tmpIsUserCreated = _tmp != 0;
          _item = new HeritageSite(_tmpSiteId,_tmpName,_tmpNameKannada,_tmpDescription,_tmpDescriptionKannada,_tmpLatitude,_tmpLongitude,_tmpAudioFilePathEn,_tmpAudioFilePathKn,_tmpImageUris,_tmpHiddenFact,_tmpHiddenFactKannada,_tmpCategory,_tmpEra,_tmpSignificance,_tmpIsUserCreated);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Flow<HeritageSite> getSiteById(final String siteId) {
    final String _sql = "SELECT * FROM heritage_sites WHERE siteId = ?";
    return FlowUtil.createFlow(__db, false, new String[] {"heritage_sites"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (siteId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, siteId);
        }
        final int _columnIndexOfSiteId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "siteId");
        final int _columnIndexOfName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "name");
        final int _columnIndexOfNameKannada = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "nameKannada");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfDescriptionKannada = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "descriptionKannada");
        final int _columnIndexOfLatitude = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "latitude");
        final int _columnIndexOfLongitude = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "longitude");
        final int _columnIndexOfAudioFilePathEn = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "audioFilePathEn");
        final int _columnIndexOfAudioFilePathKn = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "audioFilePathKn");
        final int _columnIndexOfImageUris = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "imageUris");
        final int _columnIndexOfHiddenFact = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "hiddenFact");
        final int _columnIndexOfHiddenFactKannada = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "hiddenFactKannada");
        final int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
        final int _columnIndexOfEra = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "era");
        final int _columnIndexOfSignificance = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "significance");
        final int _columnIndexOfIsUserCreated = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isUserCreated");
        final HeritageSite _result;
        if (_stmt.step()) {
          final String _tmpSiteId;
          if (_stmt.isNull(_columnIndexOfSiteId)) {
            _tmpSiteId = null;
          } else {
            _tmpSiteId = _stmt.getText(_columnIndexOfSiteId);
          }
          final String _tmpName;
          if (_stmt.isNull(_columnIndexOfName)) {
            _tmpName = null;
          } else {
            _tmpName = _stmt.getText(_columnIndexOfName);
          }
          final String _tmpNameKannada;
          if (_stmt.isNull(_columnIndexOfNameKannada)) {
            _tmpNameKannada = null;
          } else {
            _tmpNameKannada = _stmt.getText(_columnIndexOfNameKannada);
          }
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final String _tmpDescriptionKannada;
          if (_stmt.isNull(_columnIndexOfDescriptionKannada)) {
            _tmpDescriptionKannada = null;
          } else {
            _tmpDescriptionKannada = _stmt.getText(_columnIndexOfDescriptionKannada);
          }
          final double _tmpLatitude;
          _tmpLatitude = _stmt.getDouble(_columnIndexOfLatitude);
          final double _tmpLongitude;
          _tmpLongitude = _stmt.getDouble(_columnIndexOfLongitude);
          final String _tmpAudioFilePathEn;
          if (_stmt.isNull(_columnIndexOfAudioFilePathEn)) {
            _tmpAudioFilePathEn = null;
          } else {
            _tmpAudioFilePathEn = _stmt.getText(_columnIndexOfAudioFilePathEn);
          }
          final String _tmpAudioFilePathKn;
          if (_stmt.isNull(_columnIndexOfAudioFilePathKn)) {
            _tmpAudioFilePathKn = null;
          } else {
            _tmpAudioFilePathKn = _stmt.getText(_columnIndexOfAudioFilePathKn);
          }
          final String _tmpImageUris;
          if (_stmt.isNull(_columnIndexOfImageUris)) {
            _tmpImageUris = null;
          } else {
            _tmpImageUris = _stmt.getText(_columnIndexOfImageUris);
          }
          final String _tmpHiddenFact;
          if (_stmt.isNull(_columnIndexOfHiddenFact)) {
            _tmpHiddenFact = null;
          } else {
            _tmpHiddenFact = _stmt.getText(_columnIndexOfHiddenFact);
          }
          final String _tmpHiddenFactKannada;
          if (_stmt.isNull(_columnIndexOfHiddenFactKannada)) {
            _tmpHiddenFactKannada = null;
          } else {
            _tmpHiddenFactKannada = _stmt.getText(_columnIndexOfHiddenFactKannada);
          }
          final String _tmpCategory;
          if (_stmt.isNull(_columnIndexOfCategory)) {
            _tmpCategory = null;
          } else {
            _tmpCategory = _stmt.getText(_columnIndexOfCategory);
          }
          final String _tmpEra;
          if (_stmt.isNull(_columnIndexOfEra)) {
            _tmpEra = null;
          } else {
            _tmpEra = _stmt.getText(_columnIndexOfEra);
          }
          final String _tmpSignificance;
          if (_stmt.isNull(_columnIndexOfSignificance)) {
            _tmpSignificance = null;
          } else {
            _tmpSignificance = _stmt.getText(_columnIndexOfSignificance);
          }
          final boolean _tmpIsUserCreated;
          final int _tmp;
          _tmp = (int) (_stmt.getLong(_columnIndexOfIsUserCreated));
          _tmpIsUserCreated = _tmp != 0;
          _result = new HeritageSite(_tmpSiteId,_tmpName,_tmpNameKannada,_tmpDescription,_tmpDescriptionKannada,_tmpLatitude,_tmpLongitude,_tmpAudioFilePathEn,_tmpAudioFilePathKn,_tmpImageUris,_tmpHiddenFact,_tmpHiddenFactKannada,_tmpCategory,_tmpEra,_tmpSignificance,_tmpIsUserCreated);
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Object getSiteByIdOnce(final String siteId,
      final Continuation<? super HeritageSite> $completion) {
    final String _sql = "SELECT * FROM heritage_sites WHERE siteId = ?";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (siteId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, siteId);
        }
        final int _columnIndexOfSiteId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "siteId");
        final int _columnIndexOfName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "name");
        final int _columnIndexOfNameKannada = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "nameKannada");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfDescriptionKannada = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "descriptionKannada");
        final int _columnIndexOfLatitude = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "latitude");
        final int _columnIndexOfLongitude = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "longitude");
        final int _columnIndexOfAudioFilePathEn = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "audioFilePathEn");
        final int _columnIndexOfAudioFilePathKn = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "audioFilePathKn");
        final int _columnIndexOfImageUris = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "imageUris");
        final int _columnIndexOfHiddenFact = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "hiddenFact");
        final int _columnIndexOfHiddenFactKannada = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "hiddenFactKannada");
        final int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
        final int _columnIndexOfEra = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "era");
        final int _columnIndexOfSignificance = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "significance");
        final int _columnIndexOfIsUserCreated = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isUserCreated");
        final HeritageSite _result;
        if (_stmt.step()) {
          final String _tmpSiteId;
          if (_stmt.isNull(_columnIndexOfSiteId)) {
            _tmpSiteId = null;
          } else {
            _tmpSiteId = _stmt.getText(_columnIndexOfSiteId);
          }
          final String _tmpName;
          if (_stmt.isNull(_columnIndexOfName)) {
            _tmpName = null;
          } else {
            _tmpName = _stmt.getText(_columnIndexOfName);
          }
          final String _tmpNameKannada;
          if (_stmt.isNull(_columnIndexOfNameKannada)) {
            _tmpNameKannada = null;
          } else {
            _tmpNameKannada = _stmt.getText(_columnIndexOfNameKannada);
          }
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final String _tmpDescriptionKannada;
          if (_stmt.isNull(_columnIndexOfDescriptionKannada)) {
            _tmpDescriptionKannada = null;
          } else {
            _tmpDescriptionKannada = _stmt.getText(_columnIndexOfDescriptionKannada);
          }
          final double _tmpLatitude;
          _tmpLatitude = _stmt.getDouble(_columnIndexOfLatitude);
          final double _tmpLongitude;
          _tmpLongitude = _stmt.getDouble(_columnIndexOfLongitude);
          final String _tmpAudioFilePathEn;
          if (_stmt.isNull(_columnIndexOfAudioFilePathEn)) {
            _tmpAudioFilePathEn = null;
          } else {
            _tmpAudioFilePathEn = _stmt.getText(_columnIndexOfAudioFilePathEn);
          }
          final String _tmpAudioFilePathKn;
          if (_stmt.isNull(_columnIndexOfAudioFilePathKn)) {
            _tmpAudioFilePathKn = null;
          } else {
            _tmpAudioFilePathKn = _stmt.getText(_columnIndexOfAudioFilePathKn);
          }
          final String _tmpImageUris;
          if (_stmt.isNull(_columnIndexOfImageUris)) {
            _tmpImageUris = null;
          } else {
            _tmpImageUris = _stmt.getText(_columnIndexOfImageUris);
          }
          final String _tmpHiddenFact;
          if (_stmt.isNull(_columnIndexOfHiddenFact)) {
            _tmpHiddenFact = null;
          } else {
            _tmpHiddenFact = _stmt.getText(_columnIndexOfHiddenFact);
          }
          final String _tmpHiddenFactKannada;
          if (_stmt.isNull(_columnIndexOfHiddenFactKannada)) {
            _tmpHiddenFactKannada = null;
          } else {
            _tmpHiddenFactKannada = _stmt.getText(_columnIndexOfHiddenFactKannada);
          }
          final String _tmpCategory;
          if (_stmt.isNull(_columnIndexOfCategory)) {
            _tmpCategory = null;
          } else {
            _tmpCategory = _stmt.getText(_columnIndexOfCategory);
          }
          final String _tmpEra;
          if (_stmt.isNull(_columnIndexOfEra)) {
            _tmpEra = null;
          } else {
            _tmpEra = _stmt.getText(_columnIndexOfEra);
          }
          final String _tmpSignificance;
          if (_stmt.isNull(_columnIndexOfSignificance)) {
            _tmpSignificance = null;
          } else {
            _tmpSignificance = _stmt.getText(_columnIndexOfSignificance);
          }
          final boolean _tmpIsUserCreated;
          final int _tmp;
          _tmp = (int) (_stmt.getLong(_columnIndexOfIsUserCreated));
          _tmpIsUserCreated = _tmp != 0;
          _result = new HeritageSite(_tmpSiteId,_tmpName,_tmpNameKannada,_tmpDescription,_tmpDescriptionKannada,_tmpLatitude,_tmpLongitude,_tmpAudioFilePathEn,_tmpAudioFilePathKn,_tmpImageUris,_tmpHiddenFact,_tmpHiddenFactKannada,_tmpCategory,_tmpEra,_tmpSignificance,_tmpIsUserCreated);
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Flow<List<HeritageSite>> getSitesNearby(final double userLat, final double userLng,
      final double radiusKm) {
    final String _sql = "\n"
            + "        SELECT * FROM heritage_sites\n"
            + "        WHERE (6371 * acos(\n"
            + "            cos(radians(?)) * cos(radians(latitude)) *\n"
            + "            cos(radians(longitude) - radians(?)) +\n"
            + "            sin(radians(?)) * sin(radians(latitude))\n"
            + "        )) < ?\n"
            + "        ORDER BY name\n"
            + "    ";
    return FlowUtil.createFlow(__db, false, new String[] {"heritage_sites"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindDouble(_argIndex, userLat);
        _argIndex = 2;
        _stmt.bindDouble(_argIndex, userLng);
        _argIndex = 3;
        _stmt.bindDouble(_argIndex, userLat);
        _argIndex = 4;
        _stmt.bindDouble(_argIndex, radiusKm);
        final int _columnIndexOfSiteId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "siteId");
        final int _columnIndexOfName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "name");
        final int _columnIndexOfNameKannada = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "nameKannada");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfDescriptionKannada = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "descriptionKannada");
        final int _columnIndexOfLatitude = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "latitude");
        final int _columnIndexOfLongitude = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "longitude");
        final int _columnIndexOfAudioFilePathEn = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "audioFilePathEn");
        final int _columnIndexOfAudioFilePathKn = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "audioFilePathKn");
        final int _columnIndexOfImageUris = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "imageUris");
        final int _columnIndexOfHiddenFact = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "hiddenFact");
        final int _columnIndexOfHiddenFactKannada = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "hiddenFactKannada");
        final int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
        final int _columnIndexOfEra = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "era");
        final int _columnIndexOfSignificance = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "significance");
        final int _columnIndexOfIsUserCreated = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isUserCreated");
        final List<HeritageSite> _result = new ArrayList<HeritageSite>();
        while (_stmt.step()) {
          final HeritageSite _item;
          final String _tmpSiteId;
          if (_stmt.isNull(_columnIndexOfSiteId)) {
            _tmpSiteId = null;
          } else {
            _tmpSiteId = _stmt.getText(_columnIndexOfSiteId);
          }
          final String _tmpName;
          if (_stmt.isNull(_columnIndexOfName)) {
            _tmpName = null;
          } else {
            _tmpName = _stmt.getText(_columnIndexOfName);
          }
          final String _tmpNameKannada;
          if (_stmt.isNull(_columnIndexOfNameKannada)) {
            _tmpNameKannada = null;
          } else {
            _tmpNameKannada = _stmt.getText(_columnIndexOfNameKannada);
          }
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final String _tmpDescriptionKannada;
          if (_stmt.isNull(_columnIndexOfDescriptionKannada)) {
            _tmpDescriptionKannada = null;
          } else {
            _tmpDescriptionKannada = _stmt.getText(_columnIndexOfDescriptionKannada);
          }
          final double _tmpLatitude;
          _tmpLatitude = _stmt.getDouble(_columnIndexOfLatitude);
          final double _tmpLongitude;
          _tmpLongitude = _stmt.getDouble(_columnIndexOfLongitude);
          final String _tmpAudioFilePathEn;
          if (_stmt.isNull(_columnIndexOfAudioFilePathEn)) {
            _tmpAudioFilePathEn = null;
          } else {
            _tmpAudioFilePathEn = _stmt.getText(_columnIndexOfAudioFilePathEn);
          }
          final String _tmpAudioFilePathKn;
          if (_stmt.isNull(_columnIndexOfAudioFilePathKn)) {
            _tmpAudioFilePathKn = null;
          } else {
            _tmpAudioFilePathKn = _stmt.getText(_columnIndexOfAudioFilePathKn);
          }
          final String _tmpImageUris;
          if (_stmt.isNull(_columnIndexOfImageUris)) {
            _tmpImageUris = null;
          } else {
            _tmpImageUris = _stmt.getText(_columnIndexOfImageUris);
          }
          final String _tmpHiddenFact;
          if (_stmt.isNull(_columnIndexOfHiddenFact)) {
            _tmpHiddenFact = null;
          } else {
            _tmpHiddenFact = _stmt.getText(_columnIndexOfHiddenFact);
          }
          final String _tmpHiddenFactKannada;
          if (_stmt.isNull(_columnIndexOfHiddenFactKannada)) {
            _tmpHiddenFactKannada = null;
          } else {
            _tmpHiddenFactKannada = _stmt.getText(_columnIndexOfHiddenFactKannada);
          }
          final String _tmpCategory;
          if (_stmt.isNull(_columnIndexOfCategory)) {
            _tmpCategory = null;
          } else {
            _tmpCategory = _stmt.getText(_columnIndexOfCategory);
          }
          final String _tmpEra;
          if (_stmt.isNull(_columnIndexOfEra)) {
            _tmpEra = null;
          } else {
            _tmpEra = _stmt.getText(_columnIndexOfEra);
          }
          final String _tmpSignificance;
          if (_stmt.isNull(_columnIndexOfSignificance)) {
            _tmpSignificance = null;
          } else {
            _tmpSignificance = _stmt.getText(_columnIndexOfSignificance);
          }
          final boolean _tmpIsUserCreated;
          final int _tmp;
          _tmp = (int) (_stmt.getLong(_columnIndexOfIsUserCreated));
          _tmpIsUserCreated = _tmp != 0;
          _item = new HeritageSite(_tmpSiteId,_tmpName,_tmpNameKannada,_tmpDescription,_tmpDescriptionKannada,_tmpLatitude,_tmpLongitude,_tmpAudioFilePathEn,_tmpAudioFilePathKn,_tmpImageUris,_tmpHiddenFact,_tmpHiddenFactKannada,_tmpCategory,_tmpEra,_tmpSignificance,_tmpIsUserCreated);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Flow<List<HeritageSite>> getSitesByCategory(final String category) {
    final String _sql = "SELECT * FROM heritage_sites WHERE category = ? ORDER BY name";
    return FlowUtil.createFlow(__db, false, new String[] {"heritage_sites"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (category == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, category);
        }
        final int _columnIndexOfSiteId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "siteId");
        final int _columnIndexOfName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "name");
        final int _columnIndexOfNameKannada = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "nameKannada");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfDescriptionKannada = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "descriptionKannada");
        final int _columnIndexOfLatitude = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "latitude");
        final int _columnIndexOfLongitude = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "longitude");
        final int _columnIndexOfAudioFilePathEn = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "audioFilePathEn");
        final int _columnIndexOfAudioFilePathKn = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "audioFilePathKn");
        final int _columnIndexOfImageUris = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "imageUris");
        final int _columnIndexOfHiddenFact = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "hiddenFact");
        final int _columnIndexOfHiddenFactKannada = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "hiddenFactKannada");
        final int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
        final int _columnIndexOfEra = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "era");
        final int _columnIndexOfSignificance = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "significance");
        final int _columnIndexOfIsUserCreated = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "isUserCreated");
        final List<HeritageSite> _result = new ArrayList<HeritageSite>();
        while (_stmt.step()) {
          final HeritageSite _item;
          final String _tmpSiteId;
          if (_stmt.isNull(_columnIndexOfSiteId)) {
            _tmpSiteId = null;
          } else {
            _tmpSiteId = _stmt.getText(_columnIndexOfSiteId);
          }
          final String _tmpName;
          if (_stmt.isNull(_columnIndexOfName)) {
            _tmpName = null;
          } else {
            _tmpName = _stmt.getText(_columnIndexOfName);
          }
          final String _tmpNameKannada;
          if (_stmt.isNull(_columnIndexOfNameKannada)) {
            _tmpNameKannada = null;
          } else {
            _tmpNameKannada = _stmt.getText(_columnIndexOfNameKannada);
          }
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final String _tmpDescriptionKannada;
          if (_stmt.isNull(_columnIndexOfDescriptionKannada)) {
            _tmpDescriptionKannada = null;
          } else {
            _tmpDescriptionKannada = _stmt.getText(_columnIndexOfDescriptionKannada);
          }
          final double _tmpLatitude;
          _tmpLatitude = _stmt.getDouble(_columnIndexOfLatitude);
          final double _tmpLongitude;
          _tmpLongitude = _stmt.getDouble(_columnIndexOfLongitude);
          final String _tmpAudioFilePathEn;
          if (_stmt.isNull(_columnIndexOfAudioFilePathEn)) {
            _tmpAudioFilePathEn = null;
          } else {
            _tmpAudioFilePathEn = _stmt.getText(_columnIndexOfAudioFilePathEn);
          }
          final String _tmpAudioFilePathKn;
          if (_stmt.isNull(_columnIndexOfAudioFilePathKn)) {
            _tmpAudioFilePathKn = null;
          } else {
            _tmpAudioFilePathKn = _stmt.getText(_columnIndexOfAudioFilePathKn);
          }
          final String _tmpImageUris;
          if (_stmt.isNull(_columnIndexOfImageUris)) {
            _tmpImageUris = null;
          } else {
            _tmpImageUris = _stmt.getText(_columnIndexOfImageUris);
          }
          final String _tmpHiddenFact;
          if (_stmt.isNull(_columnIndexOfHiddenFact)) {
            _tmpHiddenFact = null;
          } else {
            _tmpHiddenFact = _stmt.getText(_columnIndexOfHiddenFact);
          }
          final String _tmpHiddenFactKannada;
          if (_stmt.isNull(_columnIndexOfHiddenFactKannada)) {
            _tmpHiddenFactKannada = null;
          } else {
            _tmpHiddenFactKannada = _stmt.getText(_columnIndexOfHiddenFactKannada);
          }
          final String _tmpCategory;
          if (_stmt.isNull(_columnIndexOfCategory)) {
            _tmpCategory = null;
          } else {
            _tmpCategory = _stmt.getText(_columnIndexOfCategory);
          }
          final String _tmpEra;
          if (_stmt.isNull(_columnIndexOfEra)) {
            _tmpEra = null;
          } else {
            _tmpEra = _stmt.getText(_columnIndexOfEra);
          }
          final String _tmpSignificance;
          if (_stmt.isNull(_columnIndexOfSignificance)) {
            _tmpSignificance = null;
          } else {
            _tmpSignificance = _stmt.getText(_columnIndexOfSignificance);
          }
          final boolean _tmpIsUserCreated;
          final int _tmp;
          _tmp = (int) (_stmt.getLong(_columnIndexOfIsUserCreated));
          _tmpIsUserCreated = _tmp != 0;
          _item = new HeritageSite(_tmpSiteId,_tmpName,_tmpNameKannada,_tmpDescription,_tmpDescriptionKannada,_tmpLatitude,_tmpLongitude,_tmpAudioFilePathEn,_tmpAudioFilePathKn,_tmpImageUris,_tmpHiddenFact,_tmpHiddenFactKannada,_tmpCategory,_tmpEra,_tmpSignificance,_tmpIsUserCreated);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Object countSites(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM heritage_sites";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final Integer _result;
        if (_stmt.step()) {
          final Integer _tmp;
          if (_stmt.isNull(0)) {
            _tmp = null;
          } else {
            _tmp = (int) (_stmt.getLong(0));
          }
          _result = _tmp;
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object deleteSite(final String siteId, final Continuation<? super Unit> $completion) {
    final String _sql = "DELETE FROM heritage_sites WHERE siteId = ?";
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (siteId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, siteId);
        }
        _stmt.step();
        return Unit.INSTANCE;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
