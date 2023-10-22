package NemoPackage;

class releaseCapsule extends Comando {
	
	public char key = 'm';
	
    public char getKey() {
        return key;
    }
    public void execute (Nemo nemo) {
    	nemo.releaseCapsule();
    }
}
