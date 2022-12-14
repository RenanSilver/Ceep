package com.alura.ceep.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
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

        RecyclerView listaNotas = findViewById(R.id.lista_notas_recyclerview);

        NotaDAO dao = new NotaDAO();
        for (int i = 1; i <= 10000; i++){
            dao.insere(new Nota("Titulo " + i,
                    "Descrição "+ i ));
        }
        List<Nota> todasNotas = dao.todos();

        listaNotas.setAdapter(new ListaNotasAdapter());

    }
}