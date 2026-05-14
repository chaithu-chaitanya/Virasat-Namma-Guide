package com.mindmatrix.virasatnamma.data;

import androidx.annotation.NonNull;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Long;
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
public final class CheckInDao_Impl implements CheckInDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<CheckIn> __insertAdapterOfCheckIn;

  public CheckInDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfCheckIn = new EntityInsertAdapter<CheckIn>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `check_ins` (`id`,`siteId`,`timestamp`,`hasUnlockedHiddenFact`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, @NonNull final CheckIn entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getSiteId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getSiteId());
        }
        statement.bindLong(3, entity.getTimestamp());
        final int _tmp = entity.getHasUnlockedHiddenFact() ? 1 : 0;
        statement.bindLong(4, _tmp);
      }
    };
  }

  @Override
  public Object insertCheckIn(final CheckIn checkIn, final Continuation<? super Long> $completion) {
    if (checkIn == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      return __insertAdapterOfCheckIn.insertAndReturnId(_connection, checkIn);
    }, $completion);
  }

  @Override
  public Flow<List<CheckIn>> getAllCheckIns() {
    final String _sql = "SELECT * FROM check_ins ORDER BY timestamp DESC";
    return FlowUtil.createFlow(__db, false, new String[] {"check_ins"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfSiteId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "siteId");
        final int _columnIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
        final int _columnIndexOfHasUnlockedHiddenFact = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "hasUnlockedHiddenFact");
        final List<CheckIn> _result = new ArrayList<CheckIn>();
        while (_stmt.step()) {
          final CheckIn _item;
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          final String _tmpSiteId;
          if (_stmt.isNull(_columnIndexOfSiteId)) {
            _tmpSiteId = null;
          } else {
            _tmpSiteId = _stmt.getText(_columnIndexOfSiteId);
          }
          final long _tmpTimestamp;
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp);
          final boolean _tmpHasUnlockedHiddenFact;
          final int _tmp;
          _tmp = (int) (_stmt.getLong(_columnIndexOfHasUnlockedHiddenFact));
          _tmpHasUnlockedHiddenFact = _tmp != 0;
          _item = new CheckIn(_tmpId,_tmpSiteId,_tmpTimestamp,_tmpHasUnlockedHiddenFact);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Flow<List<CheckIn>> getCheckInsForSite(final String siteId) {
    final String _sql = "SELECT * FROM check_ins WHERE siteId = ? ORDER BY timestamp DESC";
    return FlowUtil.createFlow(__db, false, new String[] {"check_ins"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (siteId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, siteId);
        }
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfSiteId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "siteId");
        final int _columnIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
        final int _columnIndexOfHasUnlockedHiddenFact = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "hasUnlockedHiddenFact");
        final List<CheckIn> _result = new ArrayList<CheckIn>();
        while (_stmt.step()) {
          final CheckIn _item;
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          final String _tmpSiteId;
          if (_stmt.isNull(_columnIndexOfSiteId)) {
            _tmpSiteId = null;
          } else {
            _tmpSiteId = _stmt.getText(_columnIndexOfSiteId);
          }
          final long _tmpTimestamp;
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp);
          final boolean _tmpHasUnlockedHiddenFact;
          final int _tmp;
          _tmp = (int) (_stmt.getLong(_columnIndexOfHasUnlockedHiddenFact));
          _tmpHasUnlockedHiddenFact = _tmp != 0;
          _item = new CheckIn(_tmpId,_tmpSiteId,_tmpTimestamp,_tmpHasUnlockedHiddenFact);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Flow<Boolean> isVisited(final String siteId) {
    final String _sql = "SELECT EXISTS(SELECT 1 FROM check_ins WHERE siteId = ?)";
    return FlowUtil.createFlow(__db, false, new String[] {"check_ins"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (siteId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, siteId);
        }
        final Boolean _result;
        if (_stmt.step()) {
          final Integer _tmp;
          if (_stmt.isNull(0)) {
            _tmp = null;
          } else {
            _tmp = (int) (_stmt.getLong(0));
          }
          _result = _tmp == null ? null : _tmp != 0;
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
  public Flow<Boolean> isHiddenFactUnlocked(final String siteId) {
    final String _sql = "SELECT EXISTS(SELECT 1 FROM check_ins WHERE siteId = ? AND hasUnlockedHiddenFact = 1)";
    return FlowUtil.createFlow(__db, false, new String[] {"check_ins"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (siteId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, siteId);
        }
        final Boolean _result;
        if (_stmt.step()) {
          final Integer _tmp;
          if (_stmt.isNull(0)) {
            _tmp = null;
          } else {
            _tmp = (int) (_stmt.getLong(0));
          }
          _result = _tmp == null ? null : _tmp != 0;
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
  public Flow<Integer> getTotalSitesVisited() {
    final String _sql = "SELECT COUNT(DISTINCT siteId) FROM check_ins";
    return FlowUtil.createFlow(__db, false, new String[] {"check_ins"}, (_connection) -> {
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
    });
  }

  @Override
  public Flow<Integer> getTotalVisits() {
    final String _sql = "SELECT COUNT(*) FROM check_ins";
    return FlowUtil.createFlow(__db, false, new String[] {"check_ins"}, (_connection) -> {
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
    });
  }

  @Override
  public Flow<Integer> getTotalHiddenFactsUnlocked() {
    final String _sql = "SELECT COUNT(*) FROM check_ins WHERE hasUnlockedHiddenFact = 1";
    return FlowUtil.createFlow(__db, false, new String[] {"check_ins"}, (_connection) -> {
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
    });
  }

  @Override
  public Flow<List<CheckInWithSite>> getCheckInHistory() {
    final String _sql = "\n"
            + "        SELECT hs.*, ci.id AS checkInId, ci.timestamp AS timestamp, ci.hasUnlockedHiddenFact AS hasUnlockedHiddenFact\n"
            + "        FROM check_ins ci\n"
            + "        INNER JOIN heritage_sites hs ON ci.siteId = hs.siteId\n"
            + "        ORDER BY ci.timestamp DESC\n"
            + "    ";
    return FlowUtil.createFlow(__db, true, new String[] {"check_ins",
        "heritage_sites"}, (_connection) -> {
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
        final int _columnIndexOfCheckInId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "checkInId");
        final int _columnIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
        final int _columnIndexOfHasUnlockedHiddenFact = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "hasUnlockedHiddenFact");
        final List<CheckInWithSite> _result = new ArrayList<CheckInWithSite>();
        while (_stmt.step()) {
          final CheckInWithSite _item;
          final int _tmpCheckInId;
          _tmpCheckInId = (int) (_stmt.getLong(_columnIndexOfCheckInId));
          final long _tmpTimestamp;
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp);
          final boolean _tmpHasUnlockedHiddenFact;
          final int _tmp;
          _tmp = (int) (_stmt.getLong(_columnIndexOfHasUnlockedHiddenFact));
          _tmpHasUnlockedHiddenFact = _tmp != 0;
          final HeritageSite _tmpSite;
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
          final int _tmp_1;
          _tmp_1 = (int) (_stmt.getLong(_columnIndexOfIsUserCreated));
          _tmpIsUserCreated = _tmp_1 != 0;
          _tmpSite = new HeritageSite(_tmpSiteId,_tmpName,_tmpNameKannada,_tmpDescription,_tmpDescriptionKannada,_tmpLatitude,_tmpLongitude,_tmpAudioFilePathEn,_tmpAudioFilePathKn,_tmpImageUris,_tmpHiddenFact,_tmpHiddenFactKannada,_tmpCategory,_tmpEra,_tmpSignificance,_tmpIsUserCreated);
          _item = new CheckInWithSite(_tmpSite,_tmpCheckInId,_tmpTimestamp,_tmpHasUnlockedHiddenFact);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Object unlockHiddenFact(final String siteId,
      final Continuation<? super Unit> $completion) {
    final String _sql = "UPDATE check_ins SET hasUnlockedHiddenFact = 1 WHERE siteId = ?";
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

  @Override
  public Object deleteForSite(final String siteId, final Continuation<? super Unit> $completion) {
    final String _sql = "DELETE FROM check_ins WHERE siteId = ?";
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
