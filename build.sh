mkdir -p bin

fsc -d bin src/main/scala/cs220/ds/*.scala
fsc -d bin -cp bin src/main/scala/cs220/Main.scala
