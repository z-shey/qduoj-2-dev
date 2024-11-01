#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LINE_LENGTH 1024

// 函数声明
void readFileAndProcess(const char *filename);
void processLine(const char *line);
void printWelcomeMessage();
void printGoodbyeMessage();

int main() {
    char filename[MAX_LINE_LENGTH];

    printWelcomeMessage();

    printf("Enter the filename to process: ");
    fgets(filename, MAX_LINE_LENGTH, stdin);
    filename[strcspn(filename, "\n")] = 0; // Remove newline character

    readFileAndProcess(filename);

    printGoodbyeMessage();

    return 0;
}

void readFileAndProcess(const char *filename) {
    FILE *file = fopen(filename, "r");
    if (file == NULL) {
        perror("Error opening file");
        return;
    }

    char line[MAX_LINE_LENGTH];
    while (fgets(line, MAX_LINE_LENGTH, file) != NULL) {
        processLine(line);
    }

    fclose(file);
}

void processLine(const char *line) {
    // 这里可以添加对每一行的处理逻辑
    printf("Processed line: %s",