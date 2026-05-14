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
public final class FavoriteDao_Impl implements FavoriteDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<Favorite> __insertAdapterOfFavorite;

  public FavoriteDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfFavorite = new EntityInsertAdapter<Favorite>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `favorites` (`siteId`,`addedTimestamp`) VALUES (?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final Favorite entity) {
        if (entity.getSiteId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getSiteId());
        }
        statement.bindLong(2, entity.getAddedTimestamp());
      }
    };
  }

  @Override
  public Object insertFavorite(final Favorite favorite,
      final Continuation<? super Unit> $completion) {
    if (favorite == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfFavorite.insert(_connection, favorite);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Flow<List<Favorite>> getAllFavorites() {
    final String _sql = "SELECT * FROM favorites ORDER BY addedTimestamp DESC";
    return FlowUtil.createFlow(__db, false, new String[] {"favorites"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfSiteId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "siteId");
        final int _columnIndexOfAddedTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "addedTimestamp");
        final List<Favorite> _result = new ArrayList<Favorite>();
        while (_stmt.step()) {
          final Favorite _item;
          final String _tmpSiteId;
          if (_stmt.isNull(_columnIndexOfSiteId)) {
            _tmpSiteId = null;
          } else {
            _tmpSiteId = _stmt.getText(_columnIndexOfSiteId);
          }
          final long _tmpAddedTimestamp;
          _tmpAddedTimestamp = _stmt.getLong(_columnIndexOfAddedTimestamp);
          _item = new Favorite(_tmpSiteId,_tmpAddedTimestamp);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @Override
  public Flow<List<HeritageSite>> getFavoriteSites() {
    final String _sql = "\n"
            + "        SELECT hs.* FROM heritage_sites hs\n"
            + "        INNER JOIN favorites f ON hs.siteId = f.siteId\n"
            + "        ORDER BY f.addedTimestamp DESC\n"
            + "    ";
    return FlowUtil.createFlow(__db, false, new String[] {"heritage_sites",
        "favorites"}, (_connection) -> {
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
  public Flow<Boolean> isFavorite(final String siteId) {
    final String _sql = "SELECT EXISTS(SELECT 1 FROM favorites WHERE siteId = ?)";
    return FlowUtil.createFlow(__db, false, new String[] {"favorites"}, (_connection) -> {
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
  public Object removeFavorite(final String siteId, final Continuation<? super Unit> $completion) {
    final String _sql = "DELETE FROM favorites WHERE siteId = ?";
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
    final String _sql = "DELETE FROM favorites WHERE siteId = ?";
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
