# Doloc Save Crypt

A simple Java application to encrypt and decrypt game save files.

## Usage

This app is a command-line tool. You must provide arguments when running the program.

### Arguments

1. **Mode**: `1` for Encrypt, `2` for Decrypt
2. **Game File Location**: Path to the input game save file
3. **File Output Location Folder** (optional): Directory where the output file will be saved. If omitted, the current directory is used.

### Example Commands

#### Encrypt a Save File
```
java -jar doloc-save-crypt.jar 1 path/to/save-game.json [output-folder]
```
- Output: `./save-game-encrypted.data`

#### Decrypt a Save File
```
java -jar doloc-save-crypt.jar 2 path/to/save-game-encrypted.data [output-folder]
```
- Output: `./save-game-decrypted.json`

- Replace `path/to/save-game.json` and `[output-folder]` with your actual file paths.
- If `[output-folder]` is omitted, the output will be saved in the current directory.

## Requirements
- Java 17 or higher

## Notes
- The application will print `Operation completed successfully.` when finished.
- Invalid arguments or modes will result in an error message.

