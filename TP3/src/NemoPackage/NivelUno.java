package NemoPackage;

import NemoPackage.OficialDeProfundidad.Nivel;

 class NivelUno extends Nivel{
	 
	 private int nivel = 1;

	public int getNivel() {
       return nivel;
   }
	
	public Nivel executeUpCommand() {

		return new Superficie();
   }

   public Nivel executeDownCommand(){
   	return new NivelMayorAUno(this);
   }

   public void releaseCapsule() {
   	Nemo.chocolateCapsuleIsReleased = true;
   }
	
}