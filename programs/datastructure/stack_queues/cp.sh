i=32
while [ $i -le 41  ]
do
	src="P"$i".java";
	echo "Copying: "$src;
	cp ../nodes/operations/$src .
	i=`expr $i + 1`
done

sh configure.sh

i=32
while [ $i -le 41  ]
do
        src="P"$i".java";
        echo "Removing: "$src;
	sudo rm -f $src
        i=`expr $i + 1`
done

