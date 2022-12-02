package foreisti.controller.utils;

public class ResponseTransfer {
	private boolean ok;
	private String text;

	public ResponseTransfer(boolean ok, String text) {
		this.ok = ok;
		this.text = text;
	}

	public boolean getOk() { return ok; }
	public String getText() { return text; }

	public void setOk(boolean b) { ok = b; }
	public void setText(String s) { text = s; }
}
