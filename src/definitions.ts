export interface AdvancedHapticsPlugin {
  vibrate(options: {
    duration?: number
    amplitude?: number
  }): Promise<void>

  vibratePattern(options: {
    pattern: number[]
    repeat?: number
  }): Promise<void>

  predefined(options: {
    type: 'click' | 'tick' | 'heavy'
  }): Promise<void>

  cancel(): Promise<void>

  hasAmplitudeControl(): Promise<{ value: boolean }>
}
