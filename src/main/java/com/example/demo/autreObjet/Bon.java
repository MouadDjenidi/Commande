package com.example.demo.autreObjet;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.DetailBon;
import com.example.demo.model.EntetBon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bon {
     private EntetBon entetBon  = new EntetBon();
     private List<DetailBon> listDetailBon = new ArrayList<DetailBon>();
}
