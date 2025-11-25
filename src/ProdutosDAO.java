/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;

    // lista compartilhada entre todas as telas
    private static ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    // contador para gerar IDs automáticos
    private static int proximoId = 1;

    // CADASTRAR PRODUTO
    public void cadastrarProduto(ProdutosDTO produto){
        // define um ID sequencial para o produto
        produto.setId(proximoId);
        proximoId++;

        // aqui o status já vem "A Venda" do cadastroVIEW
        listagem.add(produto);
    }

    // LISTAR TODOS OS PRODUTOS
    public ArrayList<ProdutosDTO> listarProdutos(){
        return listagem;
    }

    // 🚩 NOVO: VENDER PRODUTO (muda status para "Vendido")
    public void venderProduto(int id){
        for (ProdutosDTO p : listagem) {
            if (p.getId() == id) {
                p.setStatus("Vendido");
                break;
            }
        }
    }

    // 🚩 NOVO: LISTAR APENAS PRODUTOS VENDIDOS
    public ArrayList<ProdutosDTO> listarProdutosVendidos(){
        ArrayList<ProdutosDTO> vendidos = new ArrayList<>();

        for (ProdutosDTO p : listagem) {
            if ("Vendido".equalsIgnoreCase(p.getStatus())) {
                vendidos.add(p);
            }
        }

        return vendidos;
    }
}


