package NemoPackage;

class goDown extends Comando {
	
	public char key = 'd';
	
    public char getKey() {
        return key;
    }
    
    public void execute(Nemo nemo) {
         nemo.descend();
    }
}
