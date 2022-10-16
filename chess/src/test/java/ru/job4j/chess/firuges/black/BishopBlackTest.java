package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class BishopBlackTest {

    @Test
    void whenWayIsDiagonal() {
        Cell[] expected = {Cell.E7, Cell.D6};
        BishopBlack bp = new BishopBlack(Cell.F8);
        Cell[] result = bp.way(Cell.D6);
        assertArrayEquals(expected, result);

    }

    @Test
    void whenWayIsDiagonal2() {
        Cell[] expected = {Cell.B3, Cell.C4, Cell.D5, Cell.E6};
        BishopBlack bp = new BishopBlack(Cell.A2);
        Cell[] result = bp.way(Cell.E6);
        assertArrayEquals(expected, result);

    }

    @Test
    void whenWayIsVerticalThenImpossibleMoveException() {
        BishopBlack bp = new BishopBlack(Cell.F8);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class,
                () -> {
                    bp.way(Cell.D8);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from %s to %s",
                Cell.F8, Cell.D8);
    }

    @Test
    void whenWayIsHorizontalThenImpossibleMoveException() {
        BishopBlack bp = new BishopBlack(Cell.F8);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class,
                () -> {
                    bp.way(Cell.F4);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from %s to %s",
                Cell.F8, Cell.F4);
    }

    @Test
    void whenWayIsZigzagThenImpossibleMoveException() {
        BishopBlack bp = new BishopBlack(Cell.F8);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class,
                () -> {
                    bp.way(Cell.B6);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from %s to %s",
                Cell.F8, Cell.B6);
    }
}