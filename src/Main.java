import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        String entryMessage =
                "Arg 1: Mode (1: Encrypt, 2: Decrypt) - Arg 2: Game File Location - Arg 3 (optional): File Output Location Folder";
        if (args.length < 1 || args.length > 3) {
            throw new IllegalArgumentException("Invalid arguments. " + entryMessage);
        }

        String mode = args[0];
        String gameFileLocation = args[1];
        String gameFileOutputLocation = (args.length > 2) ? args[2] : null;

        Path gameFilePath = Path.of(gameFileLocation);
        Path outputPath =
                (gameFileOutputLocation != null) ? Path.of(gameFileOutputLocation).toAbsolutePath() : Path
                        .of(".")
                        .toAbsolutePath();
        String fileName = (mode.equals("1")) ? "save-game-encrypted.data" : "save-game-decrypted.json";
        Path fullOutputPath = outputPath.resolve(fileName);

        if (mode.equals("1")) {
            SaveFileHandler.encryptToFile(gameFilePath, fullOutputPath);
        } else if (mode.equals("2")) {
            SaveFileHandler.decryptToFile(gameFilePath, fullOutputPath);
        } else {
            throw new IllegalArgumentException("Invalid mode. " + entryMessage);
        }

        System.out.println("Operation completed successfully.");
    }
}