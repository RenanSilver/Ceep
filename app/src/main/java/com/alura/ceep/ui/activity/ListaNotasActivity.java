package com.alura.ceep.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alura.ceep.R;
import com.alura.ceep.dao.NotaDAO;
import com.alura.ceep.model.Nota;
import com.alura.ceep.ui.recyclerview.adapter.ListaNotasAdapter;


import java.util.List;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);
        List<Nota> todasNotas = notasDeExplo();
        configuraRecyclerView(todasNotas);

        TextView botaoInsereNota = findViewById(R.id.lista_notas_insere_nota);
        botaoInsereNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iniciaFormularioNota =
                        new Intent(ListaNotasActivity.this,
                                FormularioNotaActivity.class);
                startActivity(iniciaFormularioNota);
            }
        });


    }





    private List<Nota> notasDeExplo() {
        NotaDAO dao = new NotaDAO();
        dao.insere(new Nota("Primeiranota", "Descrição pequena"), new Nota("segunda nota", "Segunda descrição é bem amior que a da primeira nota "));
        return dao.todos();
    }

    private void configuraRecyclerView(List<Nota> todasNotas) {
        RecyclerView listaNotas = findViewById(R.id.lista_notas_recyclerview);
        configuraAdaoter(todasNotas, listaNotas);
    }

    private void configuraAdaoter(List<Nota> todasNotas, RecyclerView listaNotas) {
        listaNotas.setAdapter(new ListaNotasAdapter(this, todasNotas));
    }
}