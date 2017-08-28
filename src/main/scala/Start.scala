object Start {
  val main = new Main()

  for (i <- 1 to Runtime.getRuntime().availableProcessors()) {
    main.startMonitoringForFakeNews
    main.synchronized {
      main.wait();
    }
    main.stop
  }
}