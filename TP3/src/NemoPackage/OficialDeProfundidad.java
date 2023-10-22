package NemoPackage;

public abstract class OficialDeProfundidad {
	
	int nivel;
	
	protected abstract int getNivel();
	protected abstract Nivel executeUpCommand();
	protected abstract void releaseCapsule();
	protected abstract OficialDeProfundidad executeDownCommand();
	
	static abstract class Nivel extends OficialDeProfundidad {
		
	}
}




