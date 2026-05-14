package com.mindmatrix.virasatnamma.data;

import androidx.annotation.NonNull;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class UserAchievementDao_Impl implements UserAchievementDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<UserAchievement> __insertAdapterOfUserAchievement;

  public UserAchievementDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfUserAchievement = new EntityInsertAdapter<UserAchievement>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `user_achievements` (`achievementId`,`unlockedAt`,`progress`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final UserAchievement entity) {
        if (entity.getAchievementId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindText(1, entity.getAchievementId());
        }
        statement.bindLong(2, entity.getUnlockedAt());
        statement.bindLong(3, entity.getProgress());
      }
    };
  }

  @Override
  public Object upsert(final UserAchievement achievement,
      final Continuation<? super Unit> $completion) {
    if (achievement == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfUserAchievement.insert(_connection, achievement);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public Flow<List<UserAchievement>> getAchievements() {
    final String _sql = "SELECT * FROM user_achievements";
    return FlowUtil.createFlow(__db, false, new String[] {"user_achievements"}, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfAchievementId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "achievementId");
        final int _columnIndexOfUnlockedAt = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "unlockedAt");
        final int _columnIndexOfProgress = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "progress");
        final List<UserAchievement> _result = new ArrayList<UserAchievement>();
        while (_stmt.step()) {
          final UserAchievement _item;
          final String _tmpAchievementId;
          if (_stmt.isNull(_columnIndexOfAchievementId)) {
            _tmpAchievementId = null;
          } else {
            _tmpAchievementId = _stmt.getText(_columnIndexOfAchievementId);
          }
          final long _tmpUnlockedAt;
          _tmpUnlockedAt = _stmt.getLong(_columnIndexOfUnlockedAt);
          final int _tmpProgress;
          _tmpProgress = (int) (_stmt.getLong(_columnIndexOfProgress));
          _item = new UserAchievement(_tmpAchievementId,_tmpUnlockedAt,_tmpProgress);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
