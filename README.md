# Doloc Save Crypt

A simple Java application to encrypt and decrypt game save files from the game [Doloc Town](https://store.steampowered.com/app/2285550/Doloc_Town/).

## Usage

This app is a command-line tool. You must provide arguments when running the program.

### Arguments

1. **Mode**: `1` for Encrypt, `2` for Decrypt
2. **Game File Location**: Path to the game save file
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

## Notes
- The application will print `Operation completed successfully.` when finished.
- Invalid arguments or modes will result in an error message.

## Disclaimer
- This tool is provided for educational purposes only. I do not condone or support cheating in any form.

