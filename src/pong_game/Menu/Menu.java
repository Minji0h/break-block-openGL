package pong_game.Menu;

/**
 *
 * @author Oh Minji
 */
public abstract class Menu{

    public static Botao Iniciar;
    public static Botao Continuar;
    public static Botao Regras;
    public static Botao Sair;
    public static float mouseX = 0;
    public static float mouseY = 0;
    public int larguraFrame;
    public int alturaFrame;

    
    public static void CarregaMenu(){
        //Carrega os botões do menu
        //Botão Iniciar
        Iniciar = new Botao();
        Iniciar.pontoX = -50f;
        Iniciar.pontoX2 = 50f;
        Iniciar.pontoY = 50f;
        Iniciar.pontoY2 = 30f;
        Iniciar.texto = "Iniciar";
        Iniciar.posX = 285;
        Iniciar.posY = 260;
        Iniciar.Botao();
        //Botão Continuar
        Continuar = new Botao();
        Continuar.pontoX = -50f;
        Continuar.pontoX2 = 50f;
        Continuar.pontoY = 20f;
        Continuar.pontoY2 = 0f;
        Continuar.texto = "Continuar";
        Continuar.posX = 275;
        Continuar.posY = 195;
        Continuar.Botao();
        //Botão Regras
        Regras = new Botao();
        Regras.pontoX = -50f;
        Regras.pontoX2 = 50f;
        Regras.pontoY = -10f;
        Regras.pontoY2 = -30f;
        Regras.texto = "Regras";
        Regras.posX = 285;
        Regras.posY = 130;
        Regras.Botao();
        //Botão Sair
        Sair = new Botao();
        Sair.pontoX = -50f;
        Sair.pontoX2 = 50f;
        Sair.pontoY = -40f;
        Sair.pontoY2 = -60f;
        Sair.texto = "Sair";
        Sair.posX = 300;
        Sair.posY = 65;
        Sair.Botao();
    }
}
