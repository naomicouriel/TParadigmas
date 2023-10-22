package NemoPackage;

class goUp extends Comando {
	
	public char key = 'u';
	
    public char getKey() {
        return key;
    }
    
    public void execute(Nemo nemo) {
        nemo.ascend();
    }
}