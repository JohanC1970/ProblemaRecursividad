public class ejercicioDados {

    public static void main(String[] args) {

        int[] dados = {1, 1, 1};
        int valorSuperar = 6;

        tiradas(dados, valorSuperar, 0, 0);


    }
    public static void tiradas(int[] dados, int valorSuperar, int suma, int tirada) {

        //Si la tirada es el numero de dados y la suma es mayor que el valor a superar
        //muestro la solucion
        if (tirada == dados.length && suma > valorSuperar) {
            recorrerDados(dados,0);
            System.out.println(suma);

        } else if (tirada != dados.length) { //Evita problemas por si la tirada es mayor o igual que 3
            lanzarNuevoDado(dados, valorSuperar, suma, tirada, 1);
        }

    }

    public static void recorrerDados(int [] dados, int indice){

        if(indice < dados.length-1){
            System.out.print(dados[indice] + "+");
            recorrerDados(dados,indice+=1);
        }else if(indice == dados.length-1){
            System.out.print(dados[indice] + "=");
        }
    }

    public static void lanzarNuevoDado(int []dados,int valorSuperar,int suma, int tirada, int indice){

        if(indice<=6){
            dados[tirada] = indice; // le doy valor al dado
            suma += indice; // sumo
            tiradas(dados, valorSuperar, suma, tirada + 1);
            suma -= indice; // deshago la suma

            lanzarNuevoDado(dados, valorSuperar, suma, tirada, indice + 1); // Llamo recursivamente con la siguiente cara
        }
    }

}
