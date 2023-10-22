package NemoPackage;

import NemoPackage.OficialDeProfundidad.Nivel;

class NivelMayorAUno extends Nivel{
	
	Nivel nivelAnterior;
	private int nivel;
	
	public NivelMayorAUno(Nivel nivelAnterior) {
		this.nivelAnterior = nivelAnterior;
		nivel = nivelAnterior.getNivel() + 1;
	}
	
	public int getNivel() {
        return nivel;
    }
	public Nivel executeUpCommand() {
		return nivelAnterior;
    }

    public Nivel executeDownCommand(){
    	return new NivelMayorAUno(this);
    }

    public void releaseCapsule() {
    	Nemo.chocolateCapsuleIsReleased = false;
    	throw new RuntimeException(Nemo.CannotReleaseCapsuleInDeeperLevels);
    }
	
}
