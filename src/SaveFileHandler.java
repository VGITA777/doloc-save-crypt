import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SaveFileHandler {

    private static final String PREFIX = "DOLOC-TOWN:";
    private static final String AES_KEY = "lets-mix-lives-and-change-drinks";
    private static final String IV_KEY = "welcome-to-doloc";

    private static final AesEncryptor aesEncryptor = new AesEncryptor(AES_KEY, IV_KEY);

    public static String encrypt(Path path) {
        try {
            List<String> data = Files.readAllLines(path, StandardCharsets.UTF_8);
            StringBuilder rawData = new StringBuilder(data.size());
            StringBuilder result = new StringBuilder(data.size() + PREFIX.length());
            data.forEach(rawData::append);
            String encrypted = aesEncryptor.encrypt(rawData.toString());
            return result.append(PREFIX).append(encrypted).toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(Path path) {
        try {
            List<String> data = Files.readAllLines(path, StandardCharsets.UTF_8);
            StringBuilder encrypted = new StringBuilder(data.size());
            data.forEach(encrypted::append);
            return aesEncryptor.decrypt(encrypted.substring(PREFIX.length()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void decryptToFile(Path data, Path path) {
        try {
            Files.writeString(path, decrypt(data));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void encryptToFile(Path data, Path path) {
        try {
            Files.writeString(path, encrypt(data));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
