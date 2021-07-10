/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conect4;

import java.util.ArrayList;

/**
 *
 * @author ivanw
 */
public class Arbol {
    Nodo inicio;
	
	public Arbol(){
		inicio=null;
		
	}
	
	public Arbol(Nodo inicio) {
		this.inicio=inicio;
		this.inicio.setPadre(null);
	}
	
	public void genArbol(){
		int cont=0;
		ArrayList<Nodo> guardado=new ArrayList<Nodo>();
		guardado.add(this.inicio);
		recArb(guardado,cont);
	}
	
	private void recArb(ArrayList <Nodo> guardado,int cont){
		if(cont<4) {
			ArrayList<Nodo> paso=new ArrayList<Nodo>();
			for(int i=0;i<guardado.size();i++) {
                            ArrayList<Nodo> aux=guardado.get(i).genHijos();
                            if(aux.size()!=0){
                               guardado.get(i).setHijos(aux);
				paso.addAll(aux);
                            }
			}
			this.recArb(paso, cont+1);
		}
		else
			System.out.println("terminado con exito");
	}
        
        public Nodo poda(){
            int maxval=-1000000000,actual;
            int alpha=-1000000000;
            int beta=1000000000;
            Nodo paso=this.inicio,aux=null;
            int ward=this.alphabeta(paso, alpha, beta);
            for(Nodo N:paso.getHijos()){
                actual=this.alphabeta(N, alpha, beta);
                if(actual>maxval){
                    maxval=actual;
                    aux=N;
                }
            }
            //Nodo retorno=;
            System.out.println(aux.valuacion());
            return aux;
        }
        
        public int alphabeta(Nodo paso,int alpha,int beta){
            if(paso.getHijos()==null)
                return paso.valuacion();
            else{
                if(paso.getTipo()){
                    for(Nodo N:paso.getHijos()){
                        int guardado=alphabeta(N,alpha,beta);
                        if(guardado>alpha)
                            alpha=guardado;
                        if(alpha>=beta)
                            return beta;     
                    }
                    return alpha;
                }else{
                   for(Nodo N:paso.getHijos()){
                       int guardado=alphabeta(N,alpha,beta);
                       if(guardado<beta)
                           beta=guardado;
                       if(alpha>=beta)
                           return alpha;
                   }
                   return beta;
                }
            }
        
        }
        
        
        public void impresion(){
            int cont=0;
            Nodo aux=this.inicio;
            while(aux!=null){
                System.out.println(cont++);
                if(aux.getHijos()!=null)
                    aux=aux.getHijos().get(0);
                else
                    aux=null;
            }
      } 
}
