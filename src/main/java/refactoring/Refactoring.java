package refactoring;

import org.jetbrains.annotations.NotNull;

/**
 * The common interface for all refactorings.
 */
public interface Refactoring {
    /**
     * The delimiter for refactoring description.
     */
    String DELIMITER = "          ";

    /**
     * Returns short description of the suggested refactoring that can be exported to text file.
     */
    @NotNull
    String getDescription();
}
