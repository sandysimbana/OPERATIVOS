package cliente;

public class MainCliente {

    public static ConectorCliente cliente;

    public static void main(String[] args) {

        InterfazCliente cliente1 = new InterfazCliente();
        cliente1.show();
    }

    public static void initCliente(String ip) {
        cliente = new ConectorCliente(ip);
        cliente.start();
    }

    public static String cifrado13(String cadena) {
        //METODO PARA CIFRADO
        String Minu = "abcdefghijklmnñopqrstuvwxyz";
        String Mayu = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String texto;
        texto = cadena;
        String Cifrado = "";

        for (int n = 0; n < texto.length(); n++) {
            if ((Minu.indexOf(texto.charAt(n)) != -1) || (Mayu.indexOf(texto.charAt(n)) != -1)) {
                if (Minu.indexOf(texto.charAt(n)) != -1) {
                    Cifrado += Minu.charAt(((Minu.indexOf(texto.charAt(n))) + 13) % Minu.length());
                } else {

                    Cifrado += Mayu.charAt((Mayu.indexOf(texto.charAt(n)) + 13) % Mayu.length());
                }
            } else {
                Cifrado += texto.charAt(n);
            }
        }
        return Cifrado;
    }

    public static String DesCifrado13(String cadena) {
        //METODO PARA DESIFRADO
        String Minu = "abcdefghijklmnñopqrstuvwxyz";
        String Mayu = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String texto;
        texto = cadena;
        String DesEncrip = "";

        for (int n = 0; n < texto.length(); n++) {

            if ((Minu.indexOf(texto.charAt(n)) != -1)) {

                if ((Minu.indexOf(texto.charAt(n)) - 13) < 0) {
                    DesEncrip += Minu.charAt(Minu.length() + ((Minu.indexOf(texto.charAt(n))) - 13));
                } else {
                    DesEncrip += Minu.charAt((Minu.indexOf(texto.charAt(n))) - 13);
                }
            } else {

                if ((Mayu.indexOf(texto.charAt(n)) != -1)) {
                    if ((Mayu.indexOf(texto.charAt(n)) - 13) < 0) {
                        DesEncrip += Mayu.charAt(Mayu.length() + (Mayu.indexOf(texto.charAt(n)) - 13));
                    } else {
                        DesEncrip += Mayu.charAt((Mayu.indexOf(texto.charAt(n)) - 13));
                    }
                } else {
                    DesEncrip += texto.charAt(n);
                }

            }
        }
        return DesEncrip;

    }

}
