public class Usuario {
    public static void main(String[] args) throws Exception {

        SmartTv smartTv = new SmartTv();

        System.out.println("A TV está ligada? " + smartTv.ligada);
        System.out.println("Canal atual: " + smartTv.canal); 
        System.out.println("Volume atual: " + smartTv.volume); 

        smartTv.ligar();
        System.out.println("A TV está ligada? " + smartTv.ligada);

        smartTv.aumentarVolume();
        System.out.println("Volume atual: " + smartTv.volume); 

        smartTv.diminuirVolume();
        System.out.println("Volume atual: " + smartTv.volume); 

        smartTv.mudarCanal(12);        
        System.out.println("Canal atual: " + smartTv.canal); 

        smartTv.aumentarCanal();
        System.out.println("Canal atual: " + smartTv.canal); 

        smartTv.diminuirCanal();
        System.out.println("Canal atual: " + smartTv.canal); 

    }
}
