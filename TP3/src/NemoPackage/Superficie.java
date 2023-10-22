package NemoPackage;

import NemoPackage.OficialDeProfundidad.Nivel;

 class Superficie extends Nivel{
	
	private int nivel = 0;
	public int getNivel() {
       return nivel;
   }
	
   public Nivel executeUpCommand() {
       return this;
   }
   
   public Nivel executeDownCommand(){
   	return new NivelUno();
   }
   
   public void releaseCapsule() {
   	Nemo.capsuleIsLiberated = true;
   }
	
}