package NemoPackage;

class goForward extends Comando {
	
	public char key = 'f';
	
    public char getKey() {
        return key;
    }
    
    public void execute(Nemo nemo) {
    	nemo.moveForward();
    }
}