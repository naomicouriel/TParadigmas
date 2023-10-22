package NemoPackage;

class turnLeft extends Comando {
	
	public char key = 'l';
	
    public char getKey() {
        return key;
    }
    public void execute(Nemo nemo) {
    	nemo.rotateToLeft();
    }
}
