<?php
    
    $n = 10;

    $masses = array(3015, 4728, 4802, 4361, 135, 4444, 4313, 1413, 4581, 546);
    
    $initial_order = array(3, 10, 1, 8, 9, 4, 2, 7, 6, 5);
    
    $target_order = array(4, 9, 5, 3, 1, 6, 10, 7, 8, 2);
    
    $total_cost = main($n, $masses, $initial_order, $target_order);
    
    var_dump($total_cost);

    function main($n, $masses, $initial_order, $target_order){

        for($i=0; $i<$n; $i++){
            $p[$target_order[$i]] = $initial_order[$i];
        }

        for($i=1; $i<=$n; $i++){
            $odw[$i] = false;
        }

        $c = 0;
        for($i=1; $i<=$n; $i++){
            if(!$odw[$i]){
                $c++;
                $x = $i;
            }
            $j=0;
            while(!$odw[$x]){
                $odw[$x] = true;
                $C[$c][$j] = $x; 
                $j++;
                $x = $p[$x];
            }
        }

        $global_min = min($masses);
        
        for($i=1; $i<=$c; $i++){
            $cycle_sum[$i] = 0;
            $cycle_min[$i] = $masses[$C[$i][0]-1];      

            foreach($C[$i] as $key){
                $cycle_sum[$i] += $masses[$key-1];
                $cycle_min[$i] = min($cycle_min[$i], $masses[$key-1]);
            }
        }
        $total_cost = 0;
        for($i=1; $i<=$c; $i++){
            $method1 = $cycle_sum[$i] + (count($C[$i])-2) * $cycle_min[$i];
            $method2 = $cycle_sum[$i] + $cycle_min[$i] + (count($C[$i])+1) * $global_min;
            $total_cost += min($method1, $method2);
        }

        return $total_cost;
    }

?>