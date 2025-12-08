interface IDocument {
    void open();
    void save();
    String getContent();
    void setContent(String content);
}

class TextDocument implements IDocument {
    private String content;
    private String filename;

    public TextDocument(String filename) {
        this.filename = filename;
        this.content = "";
    }

    public void open() {
        System.out.println("Opening text document: " + filename);
        this.content = "Text content from " + filename;
    }

    public void save() {
        System.out.println("Saving text document: " + filename);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

class ImageDocument implements IDocument {
    private String filename;
    private String imageData;

    public ImageDocument(String filename) {
        this.filename = filename;
        this.imageData = "";
    }

    public void open() {
        System.out.println("Opening image document: " + filename);
        this.imageData = "Image data from " + filename;
    }

    public void save() {
        System.out.println("Saving image document: " + filename);
    }

    public String getContent() {
        return imageData;
    }

    public void setContent(String content) {
        this.imageData = content;
    }
}

class MusicDocument implements IDocument {
    private String filename;
    private String audioData;

    public MusicDocument(String filename) {
        this.filename = filename;
        this.audioData = "";
    }

    public void open() {
        System.out.println("Opening music document: " + filename);
        this.audioData = "Audio data from " + filename;
    }

    public void save() {
        System.out.println("Saving music document: " + filename);
    }

    public String getContent() {
        return audioData;
    }

    public void setContent(String content) {
        this.audioData = content;
    }
}

interface ICreateDocument {
    IDocument createNew();
    IDocument createOpen();
}

class CreateTextDocument implements ICreateDocument {
    private int documentCounter = 1;

    public IDocument createNew() {
        String filename = "NewTextDocument" + documentCounter++ + ".txt";
        return new TextDocument(filename);
    }

    public IDocument createOpen() {
        String filename = "ExistingTextDocument.txt";
        TextDocument doc = new TextDocument(filename);
        doc.open();
        return doc;
    }
}

class CreateImageDocument implements ICreateDocument {
    private int documentCounter = 1;

    public IDocument createNew() {
        String filename = "NewImageDocument" + documentCounter++ + ".png";
        return new ImageDocument(filename);
    }

    public IDocument createOpen() {
        String filename = "ExistingImageDocument.png";
        ImageDocument doc = new ImageDocument(filename);
        doc.open();
        return doc;
    }
}

class CreateMusicDocument implements ICreateDocument {
    private int documentCounter = 1;

    public IDocument createNew() {
        String filename = "NewMusicDocument" + documentCounter++ + ".mp3";
        return new MusicDocument(filename);
    }

    public IDocument createOpen() {
        String filename = "ExistingMusicDocument.mp3";
        MusicDocument doc = new MusicDocument(filename);
        doc.open();
        return doc;
    }
}

class EditorWindow {
    private IDocument currentDocument;
    private ICreateDocument documentFactory;

    public EditorWindow(ICreateDocument factory) {
        this.documentFactory = factory;
        this.currentDocument = null;
    }

    public void setDocumentFactory(ICreateDocument factory) {
        this.documentFactory = factory;
    }

    public void fileNew() {
        System.out.println("File -> New");
        currentDocument = documentFactory.createNew();
        System.out.println("Created new document: " + currentDocument.getClass().getSimpleName());
    }

    public void fileOpen() {
        System.out.println("File -> Open");
        currentDocument = documentFactory.createOpen();
        System.out.println("Opened document: " + currentDocument.getClass().getSimpleName());
    }

    public void fileSave() {
        System.out.println("File -> Save");
        if (currentDocument != null) {
            currentDocument.save();
        } else {
            System.out.println("No document to save");
        }
    }

    public void fileExit() {
        System.out.println("File -> Exit");
        System.out.println("Exiting editor...");
    }

    public void showContent() {
        if (currentDocument != null) {
            System.out.println("Current document content: " + currentDocument.getContent());
        } else {
            System.out.println("No document open");
        }
    }
}

class EditorApplication {
    public static void main(String[] args) {
        System.out.println("=== Text Editor Demo ===");
        ICreateDocument textFactory = new CreateTextDocument();
        EditorWindow textEditor = new EditorWindow(textFactory);
        
        textEditor.fileNew();
        textEditor.showContent();
        textEditor.fileSave();
        
        textEditor.fileOpen();
        textEditor.showContent();
        
        textEditor.fileSave();
        textEditor.fileExit();
        
        System.out.println("\n=== Image Editor Demo ===");
        ICreateDocument imageFactory = new CreateImageDocument();
        EditorWindow imageEditor = new EditorWindow(imageFactory);
        
        imageEditor.fileNew();
        imageEditor.showContent();
        
        System.out.println("\n=== Music Editor Demo ===");
        ICreateDocument musicFactory = new CreateMusicDocument();
        EditorWindow musicEditor = new EditorWindow(musicFactory);
        
        musicEditor.fileOpen();
        musicEditor.showContent();
        
        System.out.println("\n=== Switching Document Types ===");
        EditorWindow universalEditor = new EditorWindow(textFactory);
        
        universalEditor.fileNew();
        universalEditor.showContent();
        
        universalEditor.setDocumentFactory(imageFactory);
        universalEditor.fileOpen();
        universalEditor.showContent();
        
        universalEditor.setDocumentFactory(musicFactory);
        universalEditor.fileNew();
        universalEditor.showContent();
    }
}