package in.kunal.Bindings;

public class QuotesAPI {

	private String quote;
	private String author;

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	

    @Override
    public String toString() {
        return "QuotesAPI [quote=" + quote + "]";
    }

	
}
