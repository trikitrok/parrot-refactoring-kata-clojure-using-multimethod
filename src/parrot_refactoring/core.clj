(ns parrot-refactoring.core)

(def ^:private base-speed 12.0)

(def ^:private minimum-speed 0.0)

(defmulti speed :type)

(defmethod speed :european-parrot [_]
  base-speed)

(defmethod speed :african-parrot [{:keys [num-coconuts]}]
  (let [load-factor 9.0]
    (max minimum-speed (- base-speed (* load-factor num-coconuts)))))

(defmethod speed :norwegian-blue-parrot [{:keys [nailed voltage]}]
  (let [maximum-speed 24.0]
    (if nailed
      minimum-speed
      (min maximum-speed (* voltage base-speed)))))

(defmethod speed :default [_]
  (throw (Exception. "Should be unreachable!")))
