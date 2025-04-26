package com.task.exercise12;

public sealed interface Currency permits USD,EUR,GBP{
}

public record USD() implements Currency{
}

public record EUR() implements Currency{
}

public record GBP() implements Currency{
}