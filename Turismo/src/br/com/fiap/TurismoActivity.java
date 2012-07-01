package br.com.fiap;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TurismoActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button ok = (Button) findViewById(R.id.bntOK);
		ok.setOnClickListener(this);
	}

	public void onClick(View v) {

		TextView cidade = (TextView) findViewById(R.id.txtCidade);
		TextView estado = (TextView) findViewById(R.id.txtEstado);
		TextView pais = (TextView) findViewById(R.id.txtPais);
		TextView valorGasto = (TextView) findViewById(R.id.txtvalorGasto);
		TextView dataVisita = (TextView) findViewById(R.id.txtdataVisita);

		Log.w("Minha app", cidade.getText().toString());

		if (pais.getText().toString().equals("")) {
			this.camposObrigatorios("Campo País é obrigatório");
		}

		if (estado.getText().toString().equals("")) {
			this.camposObrigatorios("Campo estado é obrigatório");
		}

		if (cidade.getText().toString().equals("")) {
			this.camposObrigatorios("Campo cidade é obrigatório");
		}

		TurismoTO turismo = new TurismoTO(cidade.getText().toString(), estado
				.getText().toString(), pais.getText().toString(),
				Double.parseDouble(valorGasto.getText().toString()), dataVisita
						.getText().toString());
		
		TurismoDao turismoDao = new TurismoDao(this);
		turismoDao.inserir(turismo);
		turismoDao.fechar();
	}

	public void camposObrigatorios(String mensagem) {
		AlertDialog.Builder m = new AlertDialog.Builder(this);
		m.setTitle("Aviso");
		m.setMessage(mensagem);
		m.setPositiveButton("OK", null);
		m.show();
	}
}