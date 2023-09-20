
package com.mycompany.hilosadivinosdenumeros;


public class NumeroOculto {
   //GENERA EL NUMERO ALEATORIO QUE SE TENDRA QUE ADIVINAR 
  private final int NumOculto=(int) (Math.random() * 100 + 1);

    public int getNumOculto() {
        return NumOculto;
    }

   synchronized public int propuestaNuemro(int num){
        if (num==NumOculto) {
            return -1;
        }else if (num!=NumOculto) {
            return 1;
        }
        return 0;
        
        
    
    }
    
    
    
}
