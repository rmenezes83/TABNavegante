package com.example.tarde.teste_tab_navegante;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class tab01 extends Fragment {
    private static final String TAG = "tab01";
    private EditText mSearchField;
    private ImageButton mSearchBtn;
    private RecyclerView mResultList;
    private DatabaseReference mUserDatabase;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab1, container, false);
        mUserDatabase = FirebaseDatabase.getInstance().getReference("Embarcacao");
        mSearchField = (EditText) view.findViewById(R.id.search_field);
        mSearchBtn = (ImageButton) view.findViewById(R.id.btn_buscar);
        mResultList = (RecyclerView) view.findViewById(R.id.result_list);
        mResultList.setHasFixedSize(true);
        mResultList.setLayoutManager(new LinearLayoutManager(getContext()));


        mSearchBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String searchText = mSearchField.getText().toString();
                firebaseUserSearch(searchText);
            }
        });

        return view;
    }

    private void firebaseUserSearch(String searchText) {

        Toast.makeText(getContext(), "Iniciar Busca", Toast.LENGTH_LONG).show();
        Query firebaseSearchQuery = mUserDatabase.orderByChild("DestinoEmbarcacao").startAt(searchText).endAt(searchText + "\uf8ff");
        FirebaseRecyclerAdapter<Embarcacao, EmbarcViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Embarcacao, EmbarcViewHolder>(
                Embarcacao.class,R.layout.list_layout,EmbarcViewHolder.class,firebaseSearchQuery
        ) {

            protected void populateViewHolder(EmbarcViewHolder viewHolder, Embarcacao model, int position) {
                viewHolder.setDetails(getContext(), model.getNomeEmbarcacao(), model.getNomeEmpresa(),model.getTipoEmbarcacao(), model.getImagem());
            }
        };

        mResultList.setAdapter(firebaseRecyclerAdapter);
    }

}
