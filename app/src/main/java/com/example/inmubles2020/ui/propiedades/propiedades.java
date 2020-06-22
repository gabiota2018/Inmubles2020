package com.example.inmubles2020.ui.propiedades;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.inmubles2020.R;
import com.example.inmubles2020.ui.inquilino.InquilinoViewModel;
import com.example.inmubles2020.ui.perfiles.PerfilesViewModel;

import java.util.List;


public class propiedades extends Fragment {
    private ListView lv;
    private PropiedadesViewModel vm;
    private Button btnAgregar;
    public propiedades() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //vm=new PropiedadesViewModel();
        vm=ViewModelProviders.of(this).get(PropiedadesViewModel.class);
        vm.getListaDeInmuebles().observe(this,new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,strings);
                lv.setAdapter(adapter);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_propiedades, container, false);
        btnAgregar=view.findViewById(R.id.btnAgregar);
        vm.cargarDatos();
        lv=view.findViewById(R.id.listaPropiedades);
        lv.setClickable(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv=(TextView)view;
                Bundle bundle=new Bundle();
                bundle.putString("palabra",tv.getText().toString());
                Navigation.findNavController(view).navigate(R.id.detalle_propiedades, bundle);
            }
        });


        return view;
    }
}
