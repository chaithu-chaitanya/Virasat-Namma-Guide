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
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class UserProgressDao_Impl implements UserProgressDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<UserProgress> __insertAdapterOfUserProgress;

  private final EntityDeleteOrUpdateAdapter<UserProgress> __updateAdapterOfUserProgress;

  public UserProgressDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfUserProgress = new EntityInsertAdapter<UserProgress>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `user_progress` (`userId`,`totalVisits`,`sitesVisited`,`hiddenFactsUnlocked`,`favoriteLanguage`,`displayName`,`placeFrom`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final UserProgress entity) {
        statement.bindLong(1, entity.getUserId());
        statement.bindLong(2, entity.getTotalVisits());
        statement.bindLong(3, entity.getSitesVisited());
        statement.bindLong(4, entity.getHiddenFactsUnlocked());
        if (entity.getFavoriteLanguage() == null) {
          statement.bindNull(5);
        } else {
          statement.bindText(5, entity.getFavoriteLanguage());
        }
        if (entity.getDisplayName() == null) {
          statement.bindNull(6);
        } else {
          statement.bindText(6, entity.getDisplayName());
        }
        if (entity.getPlaceFrom() == null) {
          statement.bindNull(7);
        } else {
          statement.bindText(7, entity.getPlaceFrom());
        }
      }
    };
    this.__updateAdapterOfUserProgress = new EntityDeleteOrUpdateAdapter<UserProgress>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `user_progress` SET `userId` = ?,`totalVisits` = ?,`sitesVisited` = ?,`hiddenFactsUnlocked` = ?,`favoriteLanguage` = ?,`displayName` = ?,`placeFrom` = ? WHERE `userId` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final UserProgress entity) {
        statement.bindLong(1, entity.getUserId());
        statement.bindLong(2, entity.getTotalVisits());
        statement.bindLong(3, entity.getSitesVisited());
        statement.bindLong(4, entity.getHiddenFactsUnlocked());
        if (entity.getFavoriteLanguage() == null) {
          statement.bindNull(5);
        } else {
          statement.bindText(5, entity.getFavoriteLanguage());
        }
        if (entity.getDisplayName() == null) {
          statement.bindNull(6);
        } else {
          statement.bindText(6, entity.getDisplayName());
        }
        if (entity.getPlaceFrom() == null) {
          statement.bindNull(7);
        } else {
          statement.bindText(7, entity.getPlaceFrom());
        }
        statement.bindLong(8, entity.getUserId());
      }
    };
  }

  @Override
  public Object insertUserProgress(final UserProgress progress,
      final Continuation<? super Unit> $completion) {
    if (progress == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfUserProgress.insert(_connection, progress);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Object updateUserProgress(final UserProgress progress,
      final Continuation<? super Unit> $completion) {
    if (progress == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __updateAdapterOfUserProgress.handle(_connection, progress);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Flow<UserProgress> getUserProgress() {
    final String _sql = "SELECT * FROM user_progress WHERE userId = 1";
    return FlowUtil.createFlow(__db, false, new String[] {"user_progress"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
        final int _columnIndexOfTotalVisits = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalVisits");
        final int _columnIndexOfSitesVisited = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sitesVisited");
        final int _columnIndexOfHiddenFactsUnlocked = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "hiddenFactsUnlocked");
        final int _columnIndexOfFavoriteLanguage = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "favoriteLanguage");
        final int _columnIndexOfDisplayName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "displayName");
        final int _columnIndexOfPlaceFrom = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "placeFrom");
        final UserProgress _result;
        if (_stmt.step()) {
          final int _tmpUserId;
          _tmpUserId = (int) (_stmt.getLong(_columnIndexOfUserId));
          final int _tmpTotalVisits;
          _tmpTotalVisits = (int) (_stmt.getLong(_columnIndexOfTotalVisits));
          final int _tmpSitesVisited;
          _tmpSitesVisited = (int) (_stmt.getLong(_columnIndexOfSitesVisited));
          final int _tmpHiddenFactsUnlocked;
          _tmpHiddenFactsUnlocked = (int) (_stmt.getLong(_columnIndexOfHiddenFactsUnlocked));
          final String _tmpFavoriteLanguage;
          if (_stmt.isNull(_columnIndexOfFavoriteLanguage)) {
            _tmpFavoriteLanguage = null;
          } else {
            _tmpFavoriteLanguage = _stmt.getText(_columnIndexOfFavoriteLanguage);
          }
          final String _tmpDisplayName;
          if (_stmt.isNull(_columnIndexOfDisplayName)) {
            _tmpDisplayName = null;
          } else {
            _tmpDisplayName = _stmt.getText(_columnIndexOfDisplayName);
          }
          final String _tmpPlaceFrom;
          if (_stmt.isNull(_columnIndexOfPlaceFrom)) {
            _tmpPlaceFrom = null;
          } else {
            _tmpPlaceFrom = _stmt.getText(_columnIndexOfPlaceFrom);
          }
          _result = new UserProgress(_tmpUserId,_tmpTotalVisits,_tmpSitesVisited,_tmpHiddenFactsUnlocked,_tmpFavoriteLanguage,_tmpDisplayName,_tmpPlaceFrom);
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
  public Object getUserProgressOnce(final Continuation<? super UserProgress> $completion) {
    final String _sql = "SELECT * FROM user_progress WHERE userId = 1";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfUserId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "userId");
        final int _columnIndexOfTotalVisits = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "totalVisits");
        final int _columnIndexOfSitesVisited = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "sitesVisited");
        final int _columnIndexOfHiddenFactsUnlocked = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "hiddenFactsUnlocked");
        final int _columnIndexOfFavoriteLanguage = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "favoriteLanguage");
        final int _columnIndexOfDisplayName = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "displayName");
        final int _columnIndexOfPlaceFrom = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "placeFrom");
        final UserProgress _result;
        if (_stmt.step()) {
          final int _tmpUserId;
          _tmpUserId = (int) (_stmt.getLong(_columnIndexOfUserId));
          final int _tmpTotalVisits;
          _tmpTotalVisits = (int) (_stmt.getLong(_columnIndexOfTotalVisits));
          final int _tmpSitesVisited;
          _tmpSitesVisited = (int) (_stmt.getLong(_columnIndexOfSitesVisited));
          final int _tmpHiddenFactsUnlocked;
          _tmpHiddenFactsUnlocked = (int) (_stmt.getLong(_columnIndexOfHiddenFactsUnlocked));
          final String _tmpFavoriteLanguage;
          if (_stmt.isNull(_columnIndexOfFavoriteLanguage)) {
            _tmpFavoriteLanguage = null;
          } else {
            _tmpFavoriteLanguage = _stmt.getText(_columnIndexOfFavoriteLanguage);
          }
          final String _tmpDisplayName;
          if (_stmt.isNull(_columnIndexOfDisplayName)) {
            _tmpDisplayName = null;
          } else {
            _tmpDisplayName = _stmt.getText(_columnIndexOfDisplayName);
          }
          final String _tmpPlaceFrom;
          if (_stmt.isNull(_columnIndexOfPlaceFrom)) {
            _tmpPlaceFrom = null;
          } else {
            _tmpPlaceFrom = _stmt.getText(_columnIndexOfPlaceFrom);
          }
          _result = new UserProgress(_tmpUserId,_tmpTotalVisits,_tmpSitesVisited,_tmpHiddenFactsUnlocked,_tmpFavoriteLanguage,_tmpDisplayName,_tmpPlaceFrom);
        } else {
          _result = null;
        }
        return _result;
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
