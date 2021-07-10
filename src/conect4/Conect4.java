package conect4;

public class Conect4 {
    public static void main(String[] args) {    
        //despues de cada jugada recuperamos el tableto en este caso para probar vamos a gener uno vario
		int [][]tab={	{0,1,1,2,1,1,0},
				{0,1,2,2,1,1,0},
				{0,1,1,1,1,1,0},
				{0,1,2,2,1,1,0},
				{0,1,2,1,1,1,0},
				{1,2,1,1,1,1,1}};
		//generado de un nodo;
		Nodo padre=new Nodo(tab,true);
                //System.out.println(padre.genHijos());
		Arbol test=new Arbol(padre);
		test.genArbol();
                //test.impresion();
                int [][]tab2={
                        {0, 0, 0, 2, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 2, 0, 0, 0},
                        {0, 1, 0, 1, 1, 0, 0},
                        {0, 1, 2, 2, 2, 2, 0},
                        {2, 1, 1, 1, 2, 2, 0}
                };
                Nodo valuacion=new Nodo(tab2,true);
                //System.out.println(valuacion.valuacion());
                Arbol poda=new Arbol(valuacion);
                poda.genArbol();
                System.out.println(poda.poda());
    }
            
}
