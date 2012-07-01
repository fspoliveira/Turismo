package br.com.fiap;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TurismoHelper extends SQLiteOpenHelper {

	public static final String TURISMODB = "TURISMO.DB";

	public static final String VIAGEMTB = "TBVIAGEM";

	public TurismoHelper(Context context) {
		super(context, TURISMODB, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table " + VIAGEMTB
				+ " (COD_VIAGEM integer primary key autoincrement,"
				+ " CIDADE text," + " ESTADO text," + " PAIS text," + " VALOR double, "
				+ " DATA text)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		String sql = "drop table if exists " + VIAGEMTB;
		db.execSQL(sql);
		onCreate(db);
	}
}
