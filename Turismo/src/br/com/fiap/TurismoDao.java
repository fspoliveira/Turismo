package br.com.fiap;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TurismoDao {

	private SQLiteDatabase db;

	public TurismoDao(Context c) {
		TurismoHelper clienteHelper = new TurismoHelper(c);
		// db = c.openOrCreateDatabase(ClienteHelper.CLIENTEDB,
		// Context.MODE_PRIVATE, null);
		db = clienteHelper.getWritableDatabase();
		Log.w("Minha App", "Abriu BD");

	}

	public long inserir(TurismoTO turismo) {
		ContentValues valor = new ContentValues();

		valor.put("CIDADE", turismo.cidade);
		valor.put("ESTADO", turismo.estado);
		valor.put("PAIS", turismo.pais);
		valor.put("VALOR", turismo.valorGasto);
		valor.put("DATA", turismo.dataVisita.toString());

		long codViagem = db.insert(TurismoHelper.VIAGEMTB, "", valor);

		return codViagem;
	}

	public void fechar() {
		if (db != null) {
			db.close();
		}
	}

}
