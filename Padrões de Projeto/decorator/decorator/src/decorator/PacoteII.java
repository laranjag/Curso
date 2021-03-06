/*
 *
 */

package decorator;

import interfaces.IAssinatura;

/**
 *
 * @author Laranja
 */

public class PacoteII extends Pacote{

    public PacoteII(IAssinatura pacote) {
        super(pacote);
    }
    
    @Override
    public String getServico() {
        return super.getServico() + "\nPacote II";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 9.99;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + "\n - Frete Grátis em produtos.";
    }

}