package NemoPackage;

class turnRight extends Comando {
	
	public char key = 'r';
	
    public char getKey() {
        return key;
    }
    
    public void execute(Nemo nemo) {
    	nemo.rotateToRight();
    }   
}
