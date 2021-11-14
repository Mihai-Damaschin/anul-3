<?php

// 1
$x = 3;
$y = 4;

echo "Suma este " . $x + $y . "<br>";
echo "Produsul este " . $x * $y . "<br>";


// 2
$x = 3;
$y = 4;

echo "Suma patratelor este este " . pow($x, 2) + pow($y, 2) . "<br>";


// 3
$x = 3;
$y = 4;

echo "Media aritmetica este " . ($x + $y) / 2 . "<br>";


// 4
$x = 3;
$y = 4;

echo pow($x + 1, 4) - 2 * ($y - 2 * pow($x, 2) + pow($y, 2)) + sqrt(abs(sin($y))) . "<br>";


// 5
$x = 3;
$y = 4;
$z = 5;

echo "x+y/z= " . $x + $y / $z . " z+y/x= " . $z + $y / $x . " x+z/y= " . $x + $z / $y . "<br>";

// 6
$x = 6;

echo $x % 3 . " " . $x % 5 . "<br>";


// 7
$x = 10;

echo (10 * 1.3) * 2.2 . "<br>";


// 8
$x = 50;
$y = 23;

echo $x * 0.4 + $y * 0.78 . "<br>";


// 9
$x = 123;

$x1 = floor($x / 10);
$x2 = floor($x1 / 10);

echo ($x % 10) + ($x1 % 10) + $x2 . "<br>";


// 10
$x = 123;

echo floor($x / 100) . 0 . $x % 10 . "<br>";


// 11
$x = 123;

echo $x % 10 . floor($x / 10) % 10 . floor($x / 100) . "<br>";


// 12
$x = 5;
$y = 7;

$A = 2 + $x - $y;
$B = $x * $A + $y;

echo "A=" . $A . " B=" . $B . " C=" . $A - 2 * $B + $x . "<br>";


// 13
$NUME = "Damaschin";
$Virsta = 21;


// 14
echo "- Ma numesc " . $NUME . "<br>" . "- Virsta mea este:  " . $Virsta . "<br>" . "- stergeti variablia \$virsta" . "<br>";


// 15
define("TEST", "test");

echo (TEST ? 'exista' : 'nu exista') . "<br>";
echo TEST;


// 16
$age = 21;

echo ($age >= 18 && $age <= 59)
    ? 'Mai aveti mult de lucru'
    : ($age > 59
        ? "Puteti sa va pensionati"
        : ($age < 18
            ? "este inca devreme sa lucrati"
            : 'Virsta neidentificata'
        )
    );




